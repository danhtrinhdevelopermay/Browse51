# Anti-Browser Fingerprint Android Project

## Overview
This project contains 10 Android browser applications with unique fingerprinting protection. Each browser app has different spoofed parameters to prevent browser fingerprinting and tracking.

## Project Structure
```
AntiBrowserFingerprint/
├── app/
│   ├── src/main/
│   │   ├── java/com/browser/antifingerprint/
│   │   │   ├── MainActivity.kt           # Main browser activity
│   │   │   └── fingerprint/
│   │   │       ├── FingerprintProfile.kt  # Profile data class
│   │   │       └── FingerprintInjector.kt # JS injection for fingerprint spoofing
│   │   ├── res/                          # Android resources
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts                  # 10 product flavors defined here
├── .github/workflows/
│   └── build-apks.yml                    # GitHub Actions to build 10 APKs in parallel
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

## 10 Browser Profiles
Each browser has unique:
- User-Agent string
- Timezone
- Language
- Screen resolution
- Device memory
- Hardware concurrency
- WebGL vendor/renderer
- Canvas/Audio/WebGL noise values

## Building
Push to GitHub and the Actions workflow will automatically build all 10 APKs in parallel.

## Key Files
- `app/build.gradle.kts` - Contains all 10 product flavor definitions
- `app/src/main/java/.../fingerprint/FingerprintInjector.kt` - JavaScript injection for fingerprint spoofing
- `.github/workflows/build-apks.yml` - CI/CD pipeline for parallel APK builds
