plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.browser.antifingerprint"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.navigator.browser"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "2.0"

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
            applicationIdSuffix = ".xn7k"
            versionNameSuffix = "-XN7K"
            resValue("string", "app_name", "Navigator XN7K")
            buildConfigField("String", "PROFILE_ID", "\"nav_xn7k_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-G991B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.6834.15 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/New_York\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".m4tz"
            versionNameSuffix = "-M4TZ"
            resValue("string", "app_name", "Navigator M4TZ")
            buildConfigField("String", "PROFILE_ID", "\"nav_m4tz_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.200 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Berlin\"")
            buildConfigField("String", "LANGUAGE", "\"de-DE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2424")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".p8ws"
            versionNameSuffix = "-P8WS"
            resValue("string", "app_name", "Navigator P8WS")
            buildConfigField("String", "PROFILE_ID", "\"nav_p8ws_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; M2101K6G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.6668.89 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Shanghai\"")
            buildConfigField("String", "LANGUAGE", "\"zh-CN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 650\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".r2hd"
            versionNameSuffix = "-R2HD"
            resValue("string", "app_name", "Navigator R2HD")
            buildConfigField("String", "PROFILE_ID", "\"nav_r2hd_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; V2254A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.6723.58 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Singapore\"")
            buildConfigField("String", "LANGUAGE", "\"en-SG\"")
            buildConfigField("int", "SCREEN_WIDTH", "1260")
            buildConfigField("int", "SCREEN_HEIGHT", "2800")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".k9bv"
            versionNameSuffix = "-K9BV"
            resValue("string", "app_name", "Navigator K9BV")
            buildConfigField("String", "PROFILE_ID", "\"nav_k9bv_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; 2201117TG) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.6613.127 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/London\"")
            buildConfigField("String", "LANGUAGE", "\"en-GB\"")
            buildConfigField("int", "SCREEN_WIDTH", "1220")
            buildConfigField("int", "SCREEN_HEIGHT", "2712")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".t5jx"
            versionNameSuffix = "-T5JX"
            resValue("string", "app_name", "Navigator T5JX")
            buildConfigField("String", "PROFILE_ID", "\"nav_t5jx_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.135 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Los_Angeles\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3088")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".w3qp"
            versionNameSuffix = "-W3QP"
            resValue("string", "app_name", "Navigator W3QP")
            buildConfigField("String", "PROFILE_ID", "\"nav_w3qp_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; KB2001) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.103 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Kolkata\"")
            buildConfigField("String", "LANGUAGE", "\"hi-IN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 650\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".n6fy"
            versionNameSuffix = "-N6FY"
            resValue("string", "app_name", "Navigator N6FY")
            buildConfigField("String", "PROFILE_ID", "\"nav_n6fy_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; RMX3710) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.6478.186 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Manila\"")
            buildConfigField("String", "LANGUAGE", "\"en-PH\"")
            buildConfigField("int", "SCREEN_WIDTH", "1240")
            buildConfigField("int", "SCREEN_HEIGHT", "2772")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G77 MC9\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".z8cm"
            versionNameSuffix = "-Z8CM"
            resValue("string", "app_name", "Navigator Z8CM")
            buildConfigField("String", "PROFILE_ID", "\"nav_z8cm_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8a) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.6723.40 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Chicago\"")
            buildConfigField("String", "LANGUAGE", "\"es-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 MC7\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".v4ds"
            versionNameSuffix = "-V4DS"
            resValue("string", "app_name", "Navigator V4DS")
            buildConfigField("String", "PROFILE_ID", "\"nav_v4ds_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; moto g84 5G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.165 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Sao_Paulo\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2400")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 619\"")
        }

        create("browser11") {
            dimension = "browser"
            applicationIdSuffix = ".h7gl"
            versionNameSuffix = "-H7GL"
            resValue("string", "app_name", "Navigator H7GL")
            buildConfigField("String", "PROFILE_ID", "\"nav_h7gl_11\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-A556B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.6834.79 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Warsaw\"")
            buildConfigField("String", "LANGUAGE", "\"pl-PL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1080")
            buildConfigField("int", "SCREEN_HEIGHT", "2340")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser12") {
            dimension = "browser"
            applicationIdSuffix = ".b2rn"
            versionNameSuffix = "-B2RN"
            resValue("string", "app_name", "Navigator B2RN")
            buildConfigField("String", "PROFILE_ID", "\"nav_b2rn_12\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; 22071212AG) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.6668.54 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Seoul\"")
            buildConfigField("String", "LANGUAGE", "\"ko-KR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1220")
            buildConfigField("int", "SCREEN_HEIGHT", "2712")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
        }

        create("browser13") {
            dimension = "browser"
            applicationIdSuffix = ".c9ek"
            versionNameSuffix = "-C9EK"
            resValue("string", "app_name", "Navigator C9EK")
            buildConfigField("String", "PROFILE_ID", "\"nav_c9ek_13\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; PHB110) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.6613.88 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Ho_Chi_Minh\"")
            buildConfigField("String", "LANGUAGE", "\"vi-VN\"")
            buildConfigField("int", "SCREEN_WIDTH", "1264")
            buildConfigField("int", "SCREEN_HEIGHT", "2780")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser14") {
            dimension = "browser"
            applicationIdSuffix = ".f1aw"
            versionNameSuffix = "-F1AW"
            resValue("string", "app_name", "Navigator F1AW")
            buildConfigField("String", "PROFILE_ID", "\"nav_f1aw_14\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; LE2115) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.82 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Paris\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3216")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser15") {
            dimension = "browser"
            applicationIdSuffix = ".q5uj"
            versionNameSuffix = "-Q5UJ"
            resValue("string", "app_name", "Navigator Q5UJ")
            buildConfigField("String", "PROFILE_ID", "\"nav_q5uj_15\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; 2312DRA50G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.104 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Tokyo\"")
            buildConfigField("String", "LANGUAGE", "\"ja-JP\"")
            buildConfigField("int", "SCREEN_WIDTH", "1440")
            buildConfigField("int", "SCREEN_HEIGHT", "3200")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv8l\"")
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
