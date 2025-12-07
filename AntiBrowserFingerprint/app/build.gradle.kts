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
            applicationIdSuffix = ".opc9"
            versionNameSuffix = "-OPC9"
            resValue("string", "app_name", "Browser OPC9")
            buildConfigField("String", "PROFILE_ID", "\"profile_opc9_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.113 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Madrid\"")
            buildConfigField("String", "LANGUAGE", "\"de-DE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1444")
            buildConfigField("int", "SCREEN_HEIGHT", "3104")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G710 MC10\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".gh1o"
            versionNameSuffix = "-GH1O"
            resValue("string", "app_name", "Browser GH1O")
            buildConfigField("String", "PROFILE_ID", "\"profile_gh1o_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-A346B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.57 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Tokyo\"")
            buildConfigField("String", "LANGUAGE", "\"es-ES\"")
            buildConfigField("int", "SCREEN_WIDTH", "1064")
            buildConfigField("int", "SCREEN_HEIGHT", "2320")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".qmbt"
            versionNameSuffix = "-QMBT"
            resValue("string", "app_name", "Browser QMBT")
            buildConfigField("String", "PROFILE_ID", "\"profile_qmbt_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; CPH2557) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.6045.169 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/London\"")
            buildConfigField("String", "LANGUAGE", "\"es-MX\"")
            buildConfigField("int", "SCREEN_WIDTH", "1780")
            buildConfigField("int", "SCREEN_HEIGHT", "1924")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".sg0x"
            versionNameSuffix = "-SG0X"
            resValue("string", "app_name", "Browser SG0X")
            buildConfigField("String", "PROFILE_ID", "\"profile_sg0x_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-A546B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.6167.101 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Bangkok\"")
            buildConfigField("String", "LANGUAGE", "\"es-ES\"")
            buildConfigField("int", "SCREEN_WIDTH", "1096")
            buildConfigField("int", "SCREEN_HEIGHT", "2348")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".vcdz"
            versionNameSuffix = "-VCDZ"
            resValue("string", "app_name", "Browser VCDZ")
            buildConfigField("String", "PROFILE_ID", "\"profile_vcdz_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; NE2213) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.144 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Australia/Melbourne\"")
            buildConfigField("String", "LANGUAGE", "\"nl-NL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1068")
            buildConfigField("int", "SCREEN_HEIGHT", "2416")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G77 MC9\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".fu62"
            versionNameSuffix = "-FU62"
            resValue("string", "app_name", "Browser FU62")
            buildConfigField("String", "PROFILE_ID", "\"profile_fu62_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.6723.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Paris\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1356")
            buildConfigField("int", "SCREEN_HEIGHT", "2988")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".r0yr"
            versionNameSuffix = "-R0YR"
            resValue("string", "app_name", "Browser R0YR")
            buildConfigField("String", "PROFILE_ID", "\"profile_r0yr_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2557) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.113 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Australia/Sydney\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1784")
            buildConfigField("int", "SCREEN_HEIGHT", "1936")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".fxan"
            versionNameSuffix = "-FXAN"
            resValue("string", "app_name", "Browser FXAN")
            buildConfigField("String", "PROFILE_ID", "\"profile_fxan_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; ASUS_AI2203) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.5790.166 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Dubai\"")
            buildConfigField("String", "LANGUAGE", "\"ko-KR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1068")
            buildConfigField("int", "SCREEN_HEIGHT", "2392")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".a2v2"
            versionNameSuffix = "-A2V2"
            resValue("string", "app_name", "Browser A2V2")
            buildConfigField("String", "PROFILE_ID", "\"profile_a2v2_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Pixel 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.5938.154 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Dubai\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1092")
            buildConfigField("int", "SCREEN_HEIGHT", "2380")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".jezk"
            versionNameSuffix = "-JEZK"
            resValue("string", "app_name", "Browser JEZK")
            buildConfigField("String", "PROFILE_ID", "\"profile_jezk_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2557) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.85 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Bangkok\"")
            buildConfigField("String", "LANGUAGE", "\"id-ID\"")
            buildConfigField("int", "SCREEN_WIDTH", "1788")
            buildConfigField("int", "SCREEN_HEIGHT", "1920")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser11") {
            dimension = "browser"
            applicationIdSuffix = ".hnua"
            versionNameSuffix = "-HNUA"
            resValue("string", "app_name", "Browser HNUA")
            buildConfigField("String", "PROFILE_ID", "\"profile_hnua_11\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; 23127PN0CC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.179 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Moscow\"")
            buildConfigField("String", "LANGUAGE", "\"pl-PL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1208")
            buildConfigField("int", "SCREEN_HEIGHT", "2688")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser12") {
            dimension = "browser"
            applicationIdSuffix = ".ql1k"
            versionNameSuffix = "-QL1K"
            resValue("string", "app_name", "Browser QL1K")
            buildConfigField("String", "PROFILE_ID", "\"profile_ql1k_12\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; XQ-DQ72) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.5790.166 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Rome\"")
            buildConfigField("String", "LANGUAGE", "\"id-ID\"")
            buildConfigField("int", "SCREEN_WIDTH", "1628")
            buildConfigField("int", "SCREEN_HEIGHT", "3844")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser13") {
            dimension = "browser"
            applicationIdSuffix = ".a0d7"
            versionNameSuffix = "-A0D7"
            resValue("string", "app_name", "Browser A0D7")
            buildConfigField("String", "PROFILE_ID", "\"profile_a0d7_13\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.135 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Denver\"")
            buildConfigField("String", "LANGUAGE", "\"es-ES\"")
            buildConfigField("int", "SCREEN_WIDTH", "1328")
            buildConfigField("int", "SCREEN_HEIGHT", "3008")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser14") {
            dimension = "browser"
            applicationIdSuffix = ".kwxb"
            versionNameSuffix = "-KWXB"
            resValue("string", "app_name", "Browser KWXB")
            buildConfigField("String", "PROFILE_ID", "\"profile_kwxb_14\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-A546B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.40 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Pacific/Auckland\"")
            buildConfigField("String", "LANGUAGE", "\"ko-KR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1096")
            buildConfigField("int", "SCREEN_HEIGHT", "2352")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G68 MC4\"")
        }

        create("browser15") {
            dimension = "browser"
            applicationIdSuffix = ".okxr"
            versionNameSuffix = "-OKXR"
            resValue("string", "app_name", "Browser OKXR")
            buildConfigField("String", "PROFILE_ID", "\"profile_okxr_15\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S908B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.6723.40 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Jakarta\"")
            buildConfigField("String", "LANGUAGE", "\"ja-JP\"")
            buildConfigField("int", "SCREEN_WIDTH", "1448")
            buildConfigField("int", "SCREEN_HEIGHT", "3072")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
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
