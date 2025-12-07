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
            applicationIdSuffix = ".gieg"
            versionNameSuffix = "-GIEG"
            resValue("string", "app_name", "Browser GIEG")
            buildConfigField("String", "PROFILE_ID", "\"profile_gieg_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; ASUS_AI2401_A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.101 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Chicago\"")
            buildConfigField("String", "LANGUAGE", "\"en-AU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".jeq7"
            versionNameSuffix = "-JEQ7"
            resValue("string", "app_name", "Browser JEQ7")
            buildConfigField("String", "PROFILE_ID", "\"profile_jeq7_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; moto edge 40 pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.165 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Toronto\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1220")
            buildConfigField("int", "SCREEN_HEIGHT", "2712")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".rnxl"
            versionNameSuffix = "-RNXL"
            resValue("string", "app_name", "Browser RNXL")
            buildConfigField("String", "PROFILE_ID", "\"profile_rnxl_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; RMX3661) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Warsaw\"")
            buildConfigField("String", "LANGUAGE", "\"nl-NL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1240")
            buildConfigField("int", "SCREEN_HEIGHT", "2772")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".a3wy"
            versionNameSuffix = "-A3WY"
            resValue("string", "app_name", "Browser A3WY")
            buildConfigField("String", "PROFILE_ID", "\"profile_a3wy_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S928B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.60 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Toronto\"")
            buildConfigField("String", "LANGUAGE", "\"es-ES\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3120")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".xtjw"
            versionNameSuffix = "-XTJW"
            resValue("string", "app_name", "Browser XTJW")
            buildConfigField("String", "PROFILE_ID", "\"profile_xtjw_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; CPH2581) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.99 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Bangkok\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3168")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".kea3"
            versionNameSuffix = "-KEA3"
            resValue("string", "app_name", "Browser KEA3")
            buildConfigField("String", "PROFILE_ID", "\"profile_kea3_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; LE2121) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.80 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Bangkok\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".pzqw"
            versionNameSuffix = "-PZQW"
            resValue("string", "app_name", "Browser PZQW")
            buildConfigField("String", "PROFILE_ID", "\"profile_pzqw_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.143 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Sao_Paulo\"")
            buildConfigField("String", "LANGUAGE", "\"es-ES\"")
            buildConfigField("int", "SCREEN_WIDTH", "1344")
            buildConfigField("int", "SCREEN_HEIGHT", "2992")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".jdlj"
            versionNameSuffix = "-JDLJ"
            resValue("string", "app_name", "Browser JDLJ")
            buildConfigField("String", "PROFILE_ID", "\"profile_jdlj_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-A346B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.99 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Moscow\"")
            buildConfigField("String", "LANGUAGE", "\"ru-RU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2340")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".ypnv"
            versionNameSuffix = "-YPNV"
            resValue("string", "app_name", "Browser YPNV")
            buildConfigField("String", "PROFILE_ID", "\"profile_ypnv_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.165 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Chicago\"")
            buildConfigField("String", "LANGUAGE", "\"pl-PL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".aobh"
            versionNameSuffix = "-AOBH"
            resValue("string", "app_name", "Browser AOBH")
            buildConfigField("String", "PROFILE_ID", "\"profile_aobh_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2581) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.105 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Manila\"")
            buildConfigField("String", "LANGUAGE", "\"ru-RU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3168")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
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
