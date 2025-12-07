plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.browser.antifingerprint"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.browser.antifingerprint"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            storeFile = file("keystore/release.keystore")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "android"
            keyAlias = System.getenv("KEY_ALIAS") ?: "key0"
            keyPassword = System.getenv("KEY_PASSWORD") ?: "android"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isMinifyEnabled = false
        }
    }

    flavorDimensions += "browser"

    productFlavors {
        create("browser1") {
            dimension = "browser"
            applicationIdSuffix = ".b1"
            versionNameSuffix = "-B1"
            resValue("string", "app_name", "Browser 1")
            buildConfigField("String", "PROFILE_ID", "\"profile_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S928B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.230 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/New_York\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3120")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".b2"
            versionNameSuffix = "-B2"
            resValue("string", "app_name", "Browser 2")
            buildConfigField("String", "PROFILE_ID", "\"profile_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.230 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/London\"")
            buildConfigField("String", "LANGUAGE", "\"en-GB\"")
            buildConfigField("int", "SCREEN_WIDTH", "1344")
            buildConfigField("int", "SCREEN_HEIGHT", "2992")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "9")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".b3"
            versionNameSuffix = "-B3"
            resValue("string", "app_name", "Browser 3")
            buildConfigField("String", "PROFILE_ID", "\"profile_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.101 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Tokyo\"")
            buildConfigField("String", "LANGUAGE", "\"ja-JP\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3088")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".b4"
            versionNameSuffix = "-B4"
            resValue("string", "app_name", "Browser 4")
            buildConfigField("String", "PROFILE_ID", "\"profile_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; 2201116SG) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.6045.193 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Shanghai\"")
            buildConfigField("String", "LANGUAGE", "\"zh-CN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1220")
            buildConfigField("int", "SCREEN_HEIGHT", "2712")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".b5"
            versionNameSuffix = "-B5"
            resValue("string", "app_name", "Browser 5")
            buildConfigField("String", "PROFILE_ID", "\"profile_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; CPH2581) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.210 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Paris\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1240")
            buildConfigField("int", "SCREEN_HEIGHT", "2772")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".b6"
            versionNameSuffix = "-B6"
            resValue("string", "app_name", "Browser 6")
            buildConfigField("String", "PROFILE_ID", "\"profile_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; XQ-DQ72) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.5993.111 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Berlin\"")
            buildConfigField("String", "LANGUAGE", "\"de-DE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1644")
            buildConfigField("int", "SCREEN_HEIGHT", "3840")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".b7"
            versionNameSuffix = "-B7"
            resValue("string", "app_name", "Browser 7")
            buildConfigField("String", "PROFILE_ID", "\"profile_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; M2102K1G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.6045.134 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Dubai\"")
            buildConfigField("String", "LANGUAGE", "\"ar-AE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3200")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".b8"
            versionNameSuffix = "-B8"
            resValue("string", "app_name", "Browser 8")
            buildConfigField("String", "PROFILE_ID", "\"profile_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; V2254A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.144 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Ho_Chi_Minh\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1260")
            buildConfigField("int", "SCREEN_HEIGHT", "2800")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G720 Immortalis MC12\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".b9"
            versionNameSuffix = "-B9"
            resValue("string", "app_name", "Browser 9")
            buildConfigField("String", "PROFILE_ID", "\"profile_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; ASUS_AI2401_A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.143 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Singapore\"")
            buildConfigField("String", "LANGUAGE", "\"en-SG\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".b10"
            versionNameSuffix = "-B10"
            resValue("string", "app_name", "Browser 10")
            buildConfigField("String", "PROFILE_ID", "\"profile_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; moto g84 5G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.5938.140 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Sao_Paulo\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 619\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.webkit:webkit:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}
