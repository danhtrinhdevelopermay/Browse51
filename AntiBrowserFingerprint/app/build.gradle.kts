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
            applicationIdSuffix = ".l9vx"
            versionNameSuffix = "-L9VX"
            resValue("string", "app_name", "Browser L9VX")
            buildConfigField("String", "PROFILE_ID", "\"profile_l9vx_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; XQ-DE72) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Madrid\"")
            buildConfigField("String", "LANGUAGE", "\"en-AU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2520")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".5h2v"
            versionNameSuffix = "-5H2V"
            resValue("string", "app_name", "Browser 5H2V")
            buildConfigField("String", "PROFILE_ID", "\"profile_5h2v_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2551) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.119 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Chicago\"")
            buildConfigField("String", "LANGUAGE", "\"ru-RU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3168")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".fsua"
            versionNameSuffix = "-FSUA"
            resValue("string", "app_name", "Browser FSUA")
            buildConfigField("String", "PROFILE_ID", "\"profile_fsua_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; moto g84 5G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.105 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Singapore\"")
            buildConfigField("String", "LANGUAGE", "\"ms-MY\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 619\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".sz4c"
            versionNameSuffix = "-SZ4C"
            resValue("string", "app_name", "Browser SZ4C")
            buildConfigField("String", "PROFILE_ID", "\"profile_sz4c_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; LE2121) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Kolkata\"")
            buildConfigField("String", "LANGUAGE", "\"tr-TR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".cl4t"
            versionNameSuffix = "-CL4T"
            resValue("string", "app_name", "Browser CL4T")
            buildConfigField("String", "PROFILE_ID", "\"profile_cl4t_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-S928B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.105 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Bangkok\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3120")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".l2ny"
            versionNameSuffix = "-L2NY"
            resValue("string", "app_name", "Browser L2NY")
            buildConfigField("String", "PROFILE_ID", "\"profile_l2ny_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; ASUS_AI2401_A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.85 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Australia/Sydney\"")
            buildConfigField("String", "LANGUAGE", "\"sv-SE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".6z1j"
            versionNameSuffix = "-6Z1J"
            resValue("string", "app_name", "Browser 6Z1J")
            buildConfigField("String", "PROFILE_ID", "\"profile_6z1j_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.80 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Amsterdam\"")
            buildConfigField("String", "LANGUAGE", "\"ar-AE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3088")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".p8sa"
            versionNameSuffix = "-P8SA"
            resValue("string", "app_name", "Browser P8SA")
            buildConfigField("String", "PROFILE_ID", "\"profile_p8sa_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; 2201116SG) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.210 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Manila\"")
            buildConfigField("String", "LANGUAGE", "\"en-AU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3200")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".0z1z"
            versionNameSuffix = "-0Z1Z"
            resValue("string", "app_name", "Browser 0Z1Z")
            buildConfigField("String", "PROFILE_ID", "\"profile_0z1z_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; V2309) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.119 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Seoul\"")
            buildConfigField("String", "LANGUAGE", "\"id-ID\"")
            buildConfigField("int", "SCREEN_WIDTH", "2200")
            buildConfigField("int", "SCREEN_HEIGHT", "2480")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".qsks"
            versionNameSuffix = "-QSKS"
            resValue("string", "app_name", "Browser QSKS")
            buildConfigField("String", "PROFILE_ID", "\"profile_qsks_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; XQ-DE72) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Tokyo\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2520")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser11") {
            dimension = "browser"
            applicationIdSuffix = ".3zoh"
            versionNameSuffix = "-3ZOH"
            resValue("string", "app_name", "Browser 3ZOH")
            buildConfigField("String", "PROFILE_ID", "\"profile_3zoh_11\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; LE2121) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.144 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Ho_Chi_Minh\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser12") {
            dimension = "browser"
            applicationIdSuffix = ".dcly"
            versionNameSuffix = "-DCLY"
            resValue("string", "app_name", "Browser DCLY")
            buildConfigField("String", "PROFILE_ID", "\"profile_dcly_12\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-A546B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Mexico_City\"")
            buildConfigField("String", "LANGUAGE", "\"sv-SE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2340")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser13") {
            dimension = "browser"
            applicationIdSuffix = ".1jpn"
            versionNameSuffix = "-1JPN"
            resValue("string", "app_name", "Browser 1JPN")
            buildConfigField("String", "PROFILE_ID", "\"profile_1jpn_13\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; LE2121) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.82 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Vancouver\"")
            buildConfigField("String", "LANGUAGE", "\"id-ID\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser14") {
            dimension = "browser"
            applicationIdSuffix = ".ywht"
            versionNameSuffix = "-YWHT"
            resValue("string", "app_name", "Browser YWHT")
            buildConfigField("String", "PROFILE_ID", "\"profile_ywht_14\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; RMX3661) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.118 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Mexico_City\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1240")
            buildConfigField("int", "SCREEN_HEIGHT", "2772")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser15") {
            dimension = "browser"
            applicationIdSuffix = ".d1kd"
            versionNameSuffix = "-D1KD"
            resValue("string", "app_name", "Browser D1KD")
            buildConfigField("String", "PROFILE_ID", "\"profile_d1kd_15\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; 2304FPN6DC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.99 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Taipei\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3200")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
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
