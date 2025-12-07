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
            resValue("string", "app_name", "SecureBrowser 1")
            buildConfigField("String", "PROFILE_ID", "\"profile_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/New_York\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".b2"
            versionNameSuffix = "-B2"
            resValue("string", "app_name", "SecureBrowser 2")
            buildConfigField("String", "PROFILE_ID", "\"profile_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Samsung Galaxy S23) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/London\"")
            buildConfigField("String", "LANGUAGE", "\"en-GB\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3088")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Samsung\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".b3"
            versionNameSuffix = "-B3"
            resValue("string", "app_name", "SecureBrowser 3")
            buildConfigField("String", "PROFILE_ID", "\"profile_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; OnePlus 12) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Tokyo\"")
            buildConfigField("String", "LANGUAGE", "\"ja-JP\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "30")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"OnePlus\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".b4"
            versionNameSuffix = "-B4"
            resValue("string", "app_name", "SecureBrowser 4")
            buildConfigField("String", "PROFILE_ID", "\"profile_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Xiaomi 14 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Shanghai\"")
            buildConfigField("String", "LANGUAGE", "\"zh-CN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3200")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Xiaomi\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".b5"
            versionNameSuffix = "-B5"
            resValue("string", "app_name", "SecureBrowser 5")
            buildConfigField("String", "PROFILE_ID", "\"profile_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; OPPO Find X7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Paris\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1260")
            buildConfigField("int", "SCREEN_HEIGHT", "2772")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"OPPO\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".b6"
            versionNameSuffix = "-B6"
            resValue("string", "app_name", "SecureBrowser 6")
            buildConfigField("String", "PROFILE_ID", "\"profile_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Sony Xperia 1 V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Berlin\"")
            buildConfigField("String", "LANGUAGE", "\"de-DE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1644")
            buildConfigField("int", "SCREEN_HEIGHT", "3840")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Sony\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".b7"
            versionNameSuffix = "-B7"
            resValue("string", "app_name", "SecureBrowser 7")
            buildConfigField("String", "PROFILE_ID", "\"profile_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Huawei Mate 60 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Dubai\"")
            buildConfigField("String", "LANGUAGE", "\"ar-AE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1260")
            buildConfigField("int", "SCREEN_HEIGHT", "2720")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Huawei\"")
            buildConfigField("String", "RENDERER", "\"Mali-G720\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".b8"
            versionNameSuffix = "-B8"
            resValue("string", "app_name", "SecureBrowser 8")
            buildConfigField("String", "PROFILE_ID", "\"profile_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Vivo X100 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Ho_Chi_Minh\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1260")
            buildConfigField("int", "SCREEN_HEIGHT", "2800")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Vivo\"")
            buildConfigField("String", "RENDERER", "\"Mali-G720\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".b9"
            versionNameSuffix = "-B9"
            resValue("string", "app_name", "SecureBrowser 9")
            buildConfigField("String", "PROFILE_ID", "\"profile_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; ASUS ROG Phone 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Singapore\"")
            buildConfigField("String", "LANGUAGE", "\"en-SG\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"ASUS\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".b10"
            versionNameSuffix = "-B10"
            resValue("string", "app_name", "SecureBrowser 10")
            buildConfigField("String", "PROFILE_ID", "\"profile_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Motorola Edge 40 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Sao_Paulo\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Motorola\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
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
