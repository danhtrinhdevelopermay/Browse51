package com.browser.antifingerprint.fingerprint

class FingerprintInjector(private val profile: FingerprintProfile) {

    fun getInjectionScript(): String {
        return """
        (function() {
            'use strict';
            
            const config = ${profile.toJsonString()};
            
            // Only override safe Navigator properties that won't break OAuth
            // User-Agent is already set via WebView settings, so we just ensure consistency
            
            try {
                // Safe overrides that don't break authentication
                Object.defineProperty(Navigator.prototype, 'hardwareConcurrency', {
                    get: function() { return config.hardwareConcurrency; },
                    configurable: true
                });
                
                Object.defineProperty(Navigator.prototype, 'deviceMemory', {
                    get: function() { return config.deviceMemory; },
                    configurable: true
                });
                
                Object.defineProperty(Navigator.prototype, 'maxTouchPoints', {
                    get: function() { return 5; },
                    configurable: true
                });
                
                // Ensure webdriver is false (important for bot detection)
                Object.defineProperty(Navigator.prototype, 'webdriver', {
                    get: function() { return false; },
                    configurable: true
                });
            } catch(e) {}
            
            // Override Screen properties (safe, doesn't affect OAuth)
            try {
                const screenProps = {
                    width: config.screenWidth,
                    height: config.screenHeight,
                    availWidth: config.availWidth,
                    availHeight: config.availHeight,
                    colorDepth: config.colorDepth,
                    pixelDepth: config.pixelDepth
                };
                
                for (const [prop, value] of Object.entries(screenProps)) {
                    Object.defineProperty(Screen.prototype, prop, {
                        get: function() { return value; },
                        configurable: true
                    });
                }
            } catch(e) {}
            
            // WebGL Fingerprint Protection (safe for OAuth)
            const getParameterProxyHandler = {
                apply: function(target, thisArg, args) {
                    const param = args[0];
                    const gl = thisArg;
                    
                    if (param === 37445) return config.vendor; // UNMASKED_VENDOR_WEBGL
                    if (param === 37446) return config.renderer; // UNMASKED_RENDERER_WEBGL
                    
                    return Reflect.apply(target, thisArg, args);
                }
            };
            
            try {
                WebGLRenderingContext.prototype.getParameter = new Proxy(
                    WebGLRenderingContext.prototype.getParameter,
                    getParameterProxyHandler
                );
                if (typeof WebGL2RenderingContext !== 'undefined') {
                    WebGL2RenderingContext.prototype.getParameter = new Proxy(
                        WebGL2RenderingContext.prototype.getParameter,
                        getParameterProxyHandler
                    );
                }
            } catch(e) {}
            
            // Canvas Fingerprint - Light protection (minimal noise, won't break visual elements)
            const originalToDataURL = HTMLCanvasElement.prototype.toDataURL;
            HTMLCanvasElement.prototype.toDataURL = function(type) {
                // Only add noise if canvas is small (fingerprinting canvases are usually small)
                if (this.width < 500 && this.height < 500) {
                    try {
                        const context = this.getContext('2d');
                        if (context) {
                            const imageData = context.getImageData(0, 0, this.width, this.height);
                            const data = imageData.data;
                            // Very minimal noise
                            for (let i = 0; i < data.length; i += 400) {
                                data[i] = data[i] ^ 1;
                            }
                            context.putImageData(imageData, 0, 0);
                        }
                    } catch(e) {}
                }
                return originalToDataURL.apply(this, arguments);
            };
            
            // Battery API - Return realistic values
            if (navigator.getBattery) {
                const originalGetBattery = navigator.getBattery.bind(navigator);
                navigator.getBattery = function() {
                    return originalGetBattery().then(function(battery) {
                        // Return a proxy that shows reasonable values
                        return {
                            charging: battery.charging,
                            chargingTime: battery.chargingTime,
                            dischargingTime: battery.dischargingTime,
                            level: battery.level,
                            addEventListener: battery.addEventListener.bind(battery),
                            removeEventListener: battery.removeEventListener.bind(battery)
                        };
                    });
                };
            }
            
            // Connection API - Keep real values for better compatibility
            // (Removed spoofing to prevent OAuth issues)
            
            // DO NOT modify:
            // - localStorage/sessionStorage (breaks OAuth state)
            // - Timezone/Date (breaks token validation)
            // - WebRTC (might be needed for some auth flows)
            // - Cookies (essential for auth)
            // - performance.now/Date.now (breaks timing-sensitive auth)
            
            console.log('[Browser] Profile: ' + config.profileId + ' - Minimal fingerprint protection active');
            
        })();
        """.trimIndent()
    }
}
