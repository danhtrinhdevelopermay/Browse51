# Add project specific ProGuard rules here.
-keepclassmembers class com.browser.antifingerprint.** { *; }
-keep class com.browser.antifingerprint.BuildConfig { *; }
-keep class * extends android.webkit.WebViewClient
-keep class * extends android.webkit.WebChromeClient
-dontwarn okhttp3.**
-dontwarn okio.**
