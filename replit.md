# Navigator Browser - Android Project

## Overview
This project contains 10 Android browser applications with unique fingerprinting protection. Each browser app has different spoofed parameters to prevent browser fingerprinting and tracking. The Navigator browser features a modern dark theme with Indigo/Purple accent colors and a bottom toolbar design.

## Project Structure
```
AntiBrowserFingerprint/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/navigator/browser/
│   │   │   │   ├── MainActivity.kt           # Main browser activity
│   │   │   │   └── fingerprint/
│   │   │   │       ├── FingerprintProfile.kt  # Profile data class
│   │   │   │       └── FingerprintInjector.kt # JS injection for fingerprint spoofing
│   │   │   ├── res/                          # Android resources (colors, themes, layouts, drawables)
│   │   │   └── AndroidManifest.xml
│   │   ├── browser1-10/                      # Variant-specific resources (colors, layouts)
│   │   │   └── res/values/colors.xml         # Unique color schemes per variant
│   │   └── ...
│   └── build.gradle.kts                      # 15 product flavors defined here
├── profiles.json                             # 15 unique browser fingerprint profiles
├── generate_profiles.py                      # Script to generate new profiles
├── .github/workflows/
│   └── build-apks.yml                        # GitHub Actions to build APKs in parallel
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/wrapper/
```

## Technology Stack
- Language: Kotlin
- Min SDK: Android 7.0 (API 24)
- Target SDK: Android 14 (API 34)
- Build: Gradle 8.2 with Kotlin DSL
- CI/CD: GitHub Actions matrix build
- Package ID: com.navigator.browser
- Version: 2.0

## 15 Navigator Browser Profiles (Product Flavors)
Each browser has unique fingerprint parameters:
- User-Agent string (various devices: Samsung, Xiaomi, OnePlus, Google Pixel, Vivo, Realme, Motorola, Huawei, etc.)
- Timezone (America/New_York, Europe/Berlin, Asia/Shanghai, Asia/Tokyo, etc.)
- Language (en-US, de-DE, zh-CN, ja-JP, ko-KR, vi-VN, fr-FR, pt-BR, etc.)
- Screen resolution (various mobile resolutions)
- Device memory (8GB - 16GB)
- Hardware concurrency (8 cores)
- WebGL vendor/renderer (Adreno, Mali GPU variants)

Profile suffixes: xn7k, m4tz, p8ws, r2hd, k9bv, t5jx, w3qp, n6fy, z8cm, v4ds, h7gl, b2rn, c9ek, f1aw, q5uj

## Color Themes (Dark Mode)
- **browser1-10**: Custom color variants (Midnight Indigo, Emerald Dark, Purple Night, Amber Dark, Rose Dark, Teal Dark, Blue Dark, Pink Dark, Orange Dark, Slate Dark)
- **browser11-15**: Use default Indigo theme (main resources)

## UI Design
- Bottom toolbar layout (60dp height)
- WebView occupies full screen above toolbar
- Thin progress bar (2dp) above toolbar
- URL bar with integrated Go button
- Navigation buttons: Back, Forward, Refresh, Home
- Modern rounded corners and elevation effects
- Dark mode optimized

## Building
Push to GitHub and the Actions workflow will automatically build all APKs in parallel.

## Key Files
- `app/build.gradle.kts` - Contains all 15 product flavor definitions
- `profiles.json` - 15 unique fingerprint profiles
- `app/src/main/java/.../fingerprint/FingerprintInjector.kt` - JavaScript injection for fingerprint spoofing
- `app/src/main/res/values/themes.xml` - Main dark theme
- `app/src/browserX/res/values/colors.xml` - Variant-specific colors
- `.github/workflows/build-apks.yml` - CI/CD pipeline for parallel APK builds

## Recent Changes (December 2025)
- Restructured project as "Navigator Browser" (from previous browser project)
- Created 15 new unique fingerprint profiles
- Updated package ID to com.navigator.browser
- Implemented new dark theme with Indigo/Purple accents
- Redesigned UI with bottom toolbar layout
- Updated all 10 browser variant color schemes to dark mode
- Added new drawable icons for navigation
