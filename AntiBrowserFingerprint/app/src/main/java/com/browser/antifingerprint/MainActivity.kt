package com.browser.antifingerprint

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.EditorInfo
import android.webkit.*
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.browser.antifingerprint.databinding.ActivityMainBinding
import com.browser.antifingerprint.fingerprint.FingerprintProfile

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var fingerprintProfile: FingerprintProfile
    
    // Store popup dialogs to manage their lifecycle
    private val popupDialogs = mutableListOf<Dialog>()
    private val popupWebViews = mutableListOf<WebView>()
    
    companion object {
        private const val WEBVIEW_STATE_KEY = "webview_state"
        private const val CURRENT_URL_KEY = "current_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fingerprintProfile = createFingerprintProfile()

        setupWebView()
        setupUrlBar()
        setupButtons()

        if (savedInstanceState != null) {
            val webViewBundle = savedInstanceState.getBundle(WEBVIEW_STATE_KEY)
            if (webViewBundle != null) {
                webView.restoreState(webViewBundle)
            } else {
                val savedUrl = savedInstanceState.getString(CURRENT_URL_KEY)
                loadUrl(savedUrl ?: intent?.data?.toString() ?: "https://www.google.com")
            }
        } else {
            val url = intent?.data?.toString() ?: "https://www.google.com"
            loadUrl(url)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val webViewBundle = Bundle()
        webView.saveState(webViewBundle)
        outState.putBundle(WEBVIEW_STATE_KEY, webViewBundle)
        outState.putString(CURRENT_URL_KEY, webView.url)
        
        CookieManager.getInstance().flush()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val webViewBundle = savedInstanceState.getBundle(WEBVIEW_STATE_KEY)
        if (webViewBundle != null) {
            webView.restoreState(webViewBundle)
        }
    }

    private fun createFingerprintProfile(): FingerprintProfile {
        return FingerprintProfile(
            profileId = BuildConfig.PROFILE_ID,
            userAgent = BuildConfig.USER_AGENT,
            timezone = BuildConfig.TIMEZONE,
            language = BuildConfig.LANGUAGE,
            screenWidth = BuildConfig.SCREEN_WIDTH,
            screenHeight = BuildConfig.SCREEN_HEIGHT,
            colorDepth = BuildConfig.COLOR_DEPTH,
            deviceMemory = BuildConfig.DEVICE_MEMORY,
            hardwareConcurrency = BuildConfig.HARDWARE_CONCURRENCY,
            platform = BuildConfig.PLATFORM,
            vendor = BuildConfig.VENDOR,
            renderer = BuildConfig.RENDERER
        )
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView = binding.webView
        progressBar = binding.progressBar

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
            allowContentAccess = true
            allowFileAccess = false
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            cacheMode = WebSettings.LOAD_DEFAULT
            userAgentString = fingerprintProfile.userAgent
            setSupportMultipleWindows(true)
            javaScriptCanOpenWindowsAutomatically = true
            mediaPlaybackRequiresUserGesture = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                binding.urlEditText.setText(url)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                CookieManager.getInstance().flush()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url?.toString() ?: return false
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    return false
                }
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return true
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar.progress = newProgress
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                supportActionBar?.title = title ?: getString(R.string.app_name)
            }

            override fun onCreateWindow(
                view: WebView?,
                isDialog: Boolean,
                isUserGesture: Boolean,
                resultMsg: Message?
            ): Boolean {
                if (view == null || resultMsg == null) return false
                
                // Create a popup dialog to hold the new WebView
                val popupDialog = Dialog(this@MainActivity, android.R.style.Theme_DeviceDefault_NoActionBar).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setCanceledOnTouchOutside(false)
                }
                
                // Create container for the popup WebView
                val container = FrameLayout(this@MainActivity).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
                
                @SuppressLint("SetJavaScriptEnabled")
                val popupWebView = WebView(this@MainActivity).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        databaseEnabled = true
                        javaScriptCanOpenWindowsAutomatically = true
                        setSupportMultipleWindows(true)
                        mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                        userAgentString = fingerprintProfile.userAgent
                        allowContentAccess = true
                        cacheMode = WebSettings.LOAD_DEFAULT
                    }
                    
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            val url = request?.url?.toString() ?: return false
                            // Handle OAuth callback - check if it's a redirect back to the original site
                            if (url.startsWith("http://") || url.startsWith("https://")) {
                                // Let the popup WebView handle the URL normally
                                return false
                            }
                            // For non-http URLs, try to open in external app
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                startActivity(intent)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            return true
                        }
                        
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            CookieManager.getInstance().flush()
                        }
                    }
                    
                    webChromeClient = object : WebChromeClient() {
                        override fun onCloseWindow(window: WebView?) {
                            // When popup requests to close, dismiss the dialog
                            popupDialog.dismiss()
                            cleanupPopup(popupDialog, this@apply)
                            CookieManager.getInstance().flush()
                        }
                        
                        // Support nested popups if needed
                        override fun onCreateWindow(
                            view: WebView?,
                            isDialog: Boolean,
                            isUserGesture: Boolean,
                            resultMsg: Message?
                        ): Boolean {
                            return this@MainActivity.webView.webChromeClient?.onCreateWindow(
                                view, isDialog, isUserGesture, resultMsg
                            ) ?: false
                        }
                    }
                }
                
                // Setup cookies for popup
                CookieManager.getInstance().apply {
                    setAcceptCookie(true)
                    setAcceptThirdPartyCookies(popupWebView, true)
                }
                
                // Store references for cleanup
                popupDialogs.add(popupDialog)
                popupWebViews.add(popupWebView)
                
                // Add WebView to container and dialog
                container.addView(popupWebView)
                popupDialog.setContentView(container)
                
                // Handle dialog dismissal
                popupDialog.setOnDismissListener {
                    cleanupPopup(popupDialog, popupWebView)
                    CookieManager.getInstance().flush()
                }
                
                // Show the popup dialog
                popupDialog.show()
                
                // Configure dialog window size (almost full screen)
                popupDialog.window?.apply {
                    setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
                
                // Send the WebView transport
                val transport = resultMsg.obj as WebView.WebViewTransport
                transport.webView = popupWebView
                resultMsg.sendToTarget()
                return true
            }

            override fun onCloseWindow(window: WebView?) {
                super.onCloseWindow(window)
                // Find and close the popup containing this window
                val index = popupWebViews.indexOf(window)
                if (index >= 0 && index < popupDialogs.size) {
                    popupDialogs[index].dismiss()
                }
                CookieManager.getInstance().flush()
            }
        }

        CookieManager.getInstance().apply {
            setAcceptCookie(true)
            setAcceptThirdPartyCookies(webView, true)
        }
    }

    private fun setupUrlBar() {
        binding.urlEditText.setOnEditorActionListener { textView, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO ||
                (event?.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                val url = textView.text.toString()
                loadUrl(url)
                true
            } else {
                false
            }
        }
    }

    private fun setupButtons() {
        binding.btnBack.setOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }

        binding.btnForward.setOnClickListener {
            if (webView.canGoForward()) webView.goForward()
        }

        binding.btnRefresh.setOnClickListener {
            webView.reload()
        }

        binding.btnHome.setOnClickListener {
            loadUrl("https://www.google.com")
        }

        binding.btnGo.setOnClickListener {
            loadUrl(binding.urlEditText.text.toString())
        }
    }

    private fun loadUrl(inputUrl: String) {
        val url = when {
            inputUrl.startsWith("http://") || inputUrl.startsWith("https://") -> inputUrl
            inputUrl.contains(".") -> "https://$inputUrl"
            else -> "https://www.google.com/search?q=${Uri.encode(inputUrl)}"
        }
        webView.loadUrl(url)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        val url = intent?.data?.toString()
        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            loadUrl(url)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        webView.onPause()
        CookieManager.getInstance().flush()
        super.onPause()
    }

    override fun onDestroy() {
        // Clean up all popups
        cleanupAllPopups()
        CookieManager.getInstance().flush()
        webView.destroy()
        super.onDestroy()
    }
    
    private fun cleanupPopup(dialog: Dialog, webView: WebView) {
        try {
            webView.stopLoading()
            webView.destroy()
            popupWebViews.remove(webView)
            popupDialogs.remove(dialog)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    private fun cleanupAllPopups() {
        for (i in popupDialogs.indices.reversed()) {
            try {
                if (popupDialogs[i].isShowing) {
                    popupDialogs[i].dismiss()
                }
                popupWebViews.getOrNull(i)?.apply {
                    stopLoading()
                    destroy()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        popupDialogs.clear()
        popupWebViews.clear()
    }
}
