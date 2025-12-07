package com.browser.antifingerprint.fingerprint

class FingerprintInjector(private val profile: FingerprintProfile) {

    fun getInjectionScript(): String {
        return """
        (function() {
            'use strict';
            
            const config = ${profile.toJsonString()};
            
            // Override Navigator properties
            const navigatorProps = {
                userAgent: { value: config.userAgent },
                appVersion: { value: config.userAgent.replace('Mozilla/', '') },
                platform: { value: config.platform },
                language: { value: config.language },
                languages: { value: Object.freeze(config.languages) },
                hardwareConcurrency: { value: config.hardwareConcurrency },
                deviceMemory: { value: config.deviceMemory },
                vendor: { value: config.vendor },
                maxTouchPoints: { value: 5 },
                webdriver: { value: false },
                cookieEnabled: { value: true },
                doNotTrack: { value: "1" }
            };
            
            for (const [prop, descriptor] of Object.entries(navigatorProps)) {
                try {
                    Object.defineProperty(Navigator.prototype, prop, {
                        get: function() { return descriptor.value; },
                        configurable: true
                    });
                } catch(e) {}
            }
            
            // Override Screen properties
            const screenProps = {
                width: config.screenWidth,
                height: config.screenHeight,
                availWidth: config.availWidth,
                availHeight: config.availHeight,
                colorDepth: config.colorDepth,
                pixelDepth: config.pixelDepth
            };
            
            for (const [prop, value] of Object.entries(screenProps)) {
                try {
                    Object.defineProperty(Screen.prototype, prop, {
                        get: function() { return value; },
                        configurable: true
                    });
                } catch(e) {}
            }
            
            // Override window dimensions
            try {
                Object.defineProperty(window, 'innerWidth', { get: () => config.screenWidth });
                Object.defineProperty(window, 'innerHeight', { get: () => config.availHeight });
                Object.defineProperty(window, 'outerWidth', { get: () => config.screenWidth });
                Object.defineProperty(window, 'outerHeight', { get: () => config.screenHeight });
            } catch(e) {}
            
            // Override Timezone
            const originalDateTimeFormat = Intl.DateTimeFormat;
            Intl.DateTimeFormat = function(locales, options) {
                options = options || {};
                options.timeZone = options.timeZone || config.timezone;
                return new originalDateTimeFormat(locales, options);
            };
            Intl.DateTimeFormat.prototype = originalDateTimeFormat.prototype;
            
            const originalResolvedOptions = Intl.DateTimeFormat.prototype.resolvedOptions;
            Intl.DateTimeFormat.prototype.resolvedOptions = function() {
                const result = originalResolvedOptions.call(this);
                result.timeZone = config.timezone;
                return result;
            };
            
            // Override Date timezone offset
            const targetOffset = getTimezoneOffset(config.timezone);
            Date.prototype.getTimezoneOffset = function() {
                return targetOffset;
            };
            
            function getTimezoneOffset(tz) {
                const offsets = {
                    'America/New_York': 300,
                    'Europe/London': 0,
                    'Asia/Tokyo': -540,
                    'Asia/Shanghai': -480,
                    'Europe/Paris': -60,
                    'Europe/Berlin': -60,
                    'Asia/Dubai': -240,
                    'Asia/Ho_Chi_Minh': -420,
                    'Asia/Singapore': -480,
                    'America/Sao_Paulo': 180
                };
                return offsets[tz] || 0;
            }
            
            // Canvas Fingerprint Protection
            const originalToDataURL = HTMLCanvasElement.prototype.toDataURL;
            HTMLCanvasElement.prototype.toDataURL = function(type) {
                const context = this.getContext('2d');
                if (context) {
                    const imageData = context.getImageData(0, 0, this.width, this.height);
                    const data = imageData.data;
                    for (let i = 0; i < data.length; i += 4) {
                        data[i] = data[i] ^ (Math.floor(config.canvasNoise * 255) & 0xFF);
                    }
                    context.putImageData(imageData, 0, 0);
                }
                return originalToDataURL.apply(this, arguments);
            };
            
            const originalGetImageData = CanvasRenderingContext2D.prototype.getImageData;
            CanvasRenderingContext2D.prototype.getImageData = function() {
                const imageData = originalGetImageData.apply(this, arguments);
                const data = imageData.data;
                for (let i = 0; i < data.length; i += 4) {
                    data[i] = data[i] ^ (Math.floor(config.canvasNoise * 255) & 0xFF);
                }
                return imageData;
            };
            
            // WebGL Fingerprint Protection
            const getParameterProxyHandler = {
                apply: function(target, thisArg, args) {
                    const param = args[0];
                    const gl = thisArg;
                    
                    if (param === gl.VENDOR) return config.vendor;
                    if (param === gl.RENDERER) return config.renderer;
                    if (param === gl.VERSION) return 'WebGL 2.0 (OpenGL ES 3.0)';
                    if (param === gl.SHADING_LANGUAGE_VERSION) return 'WebGL GLSL ES 3.00';
                    if (param === gl.UNMASKED_VENDOR_WEBGL) return config.vendor;
                    if (param === gl.UNMASKED_RENDERER_WEBGL) return config.renderer;
                    
                    return Reflect.apply(target, thisArg, args);
                }
            };
            
            try {
                WebGLRenderingContext.prototype.getParameter = new Proxy(
                    WebGLRenderingContext.prototype.getParameter,
                    getParameterProxyHandler
                );
                WebGL2RenderingContext.prototype.getParameter = new Proxy(
                    WebGL2RenderingContext.prototype.getParameter,
                    getParameterProxyHandler
                );
            } catch(e) {}
            
            // Audio Fingerprint Protection
            const originalGetChannelData = AudioBuffer.prototype.getChannelData;
            AudioBuffer.prototype.getChannelData = function(channel) {
                const data = originalGetChannelData.call(this, channel);
                for (let i = 0; i < data.length; i++) {
                    data[i] = data[i] + (config.audioNoise * (Math.random() - 0.5));
                }
                return data;
            };
            
            // Plugins spoofing (empty array for privacy)
            try {
                Object.defineProperty(Navigator.prototype, 'plugins', {
                    get: function() {
                        return Object.setPrototypeOf([], PluginArray.prototype);
                    }
                });
                Object.defineProperty(Navigator.prototype, 'mimeTypes', {
                    get: function() {
                        return Object.setPrototypeOf([], MimeTypeArray.prototype);
                    }
                });
            } catch(e) {}
            
            // Battery API spoofing
            if (navigator.getBattery) {
                navigator.getBattery = function() {
                    return Promise.resolve({
                        charging: true,
                        chargingTime: Infinity,
                        dischargingTime: Infinity,
                        level: 1.0,
                        addEventListener: function() {},
                        removeEventListener: function() {}
                    });
                };
            }
            
            // Connection API spoofing
            try {
                Object.defineProperty(Navigator.prototype, 'connection', {
                    get: function() {
                        return {
                            effectiveType: '4g',
                            rtt: 50,
                            downlink: 10,
                            saveData: false,
                            addEventListener: function() {},
                            removeEventListener: function() {}
                        };
                    }
                });
            } catch(e) {}
            
            // Prevent font enumeration
            const originalFontCheck = document.fonts;
            if (originalFontCheck && originalFontCheck.check) {
                document.fonts.check = function(font) {
                    const commonFonts = ['Arial', 'Helvetica', 'Times New Roman', 'Georgia', 'Verdana'];
                    const fontFamily = font.split(' ').pop().replace(/"/g, '');
                    return commonFonts.includes(fontFamily);
                };
            }
            
            // Disable WebRTC IP leak - Comprehensive protection
            if (window.RTCPeerConnection) {
                const originalRTCPeerConnection = window.RTCPeerConnection;
                window.RTCPeerConnection = function(config, constraints) {
                    if (config && config.iceServers) {
                        config.iceServers = [];
                    }
                    const pc = new originalRTCPeerConnection(config, constraints);
                    
                    const originalCreateOffer = pc.createOffer.bind(pc);
                    pc.createOffer = function(options) {
                        options = options || {};
                        options.iceRestart = false;
                        return originalCreateOffer(options);
                    };
                    
                    const originalAddIceCandidate = pc.addIceCandidate.bind(pc);
                    pc.addIceCandidate = function(candidate) {
                        if (candidate && candidate.candidate && candidate.candidate.indexOf('srflx') !== -1) {
                            return Promise.resolve();
                        }
                        return originalAddIceCandidate(candidate);
                    };
                    
                    return pc;
                };
                window.RTCPeerConnection.prototype = originalRTCPeerConnection.prototype;
            }
            
            // LocalStorage and SessionStorage isolation per profile
            const storagePrefix = 'profile_' + config.profileId + '_';
            
            const originalLocalStorageSetItem = localStorage.setItem.bind(localStorage);
            const originalLocalStorageGetItem = localStorage.getItem.bind(localStorage);
            const originalLocalStorageRemoveItem = localStorage.removeItem.bind(localStorage);
            
            localStorage.setItem = function(key, value) {
                return originalLocalStorageSetItem(storagePrefix + key, value);
            };
            localStorage.getItem = function(key) {
                return originalLocalStorageGetItem(storagePrefix + key);
            };
            localStorage.removeItem = function(key) {
                return originalLocalStorageRemoveItem(storagePrefix + key);
            };
            
            const originalSessionStorageSetItem = sessionStorage.setItem.bind(sessionStorage);
            const originalSessionStorageGetItem = sessionStorage.getItem.bind(sessionStorage);
            const originalSessionStorageRemoveItem = sessionStorage.removeItem.bind(sessionStorage);
            
            sessionStorage.setItem = function(key, value) {
                return originalSessionStorageSetItem(storagePrefix + key, value);
            };
            sessionStorage.getItem = function(key) {
                return originalSessionStorageGetItem(storagePrefix + key);
            };
            sessionStorage.removeItem = function(key) {
                return originalSessionStorageRemoveItem(storagePrefix + key);
            };
            
            // Spoof performance timing for behavior tracking protection
            const originalPerformanceNow = performance.now.bind(performance);
            performance.now = function() {
                return originalPerformanceNow() + (Math.random() * 0.1);
            };
            
            // Reduce timing precision for privacy
            const originalDateNow = Date.now;
            Date.now = function() {
                return Math.floor(originalDateNow() / 100) * 100;
            };
            
            console.log('[AntiFingerprint] Profile: ' + config.profileId + ' loaded with full protection');
            
        })();
        """.trimIndent()
    }
}
