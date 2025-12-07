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
            applicationIdSuffix = ".gyco"
            versionNameSuffix = "-GYCO"
            resValue("string", "app_name", "Browser GYCO")
            buildConfigField("String", "PROFILE_ID", "\"profile_gyco_1\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2449) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.118 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Taipei\"")
            buildConfigField("String", "LANGUAGE", "\"ko-KR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1456")
            buildConfigField("int", "SCREEN_HEIGHT", "3212")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "24")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser2") {
            dimension = "browser"
            applicationIdSuffix = ".eoyb"
            versionNameSuffix = "-EOYB"
            resValue("string", "app_name", "Browser EOYB")
            buildConfigField("String", "PROFILE_ID", "\"profile_eoyb_2\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; SM-S928B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Kuala_Lumpur\"")
            buildConfigField("String", "LANGUAGE", "\"fr-FR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1456")
            buildConfigField("int", "SCREEN_HEIGHT", "3132")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser3") {
            dimension = "browser"
            applicationIdSuffix = ".6wrb"
            versionNameSuffix = "-6WRB"
            resValue("string", "app_name", "Browser 6WRB")
            buildConfigField("String", "PROFILE_ID", "\"profile_6wrb_3\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; SM-S928B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.6045.134 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Australia/Sydney\"")
            buildConfigField("String", "LANGUAGE", "\"zh-TW\"")
            buildConfigField("int", "SCREEN_WIDTH", "1436")
            buildConfigField("int", "SCREEN_HEIGHT", "3112")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser4") {
            dimension = "browser"
            applicationIdSuffix = ".9uvc"
            versionNameSuffix = "-9UVC"
            resValue("string", "app_name", "Browser 9UVC")
            buildConfigField("String", "PROFILE_ID", "\"profile_9uvc_4\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.6613.84 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Los_Angeles\"")
            buildConfigField("String", "LANGUAGE", "\"en-US\"")
            buildConfigField("int", "SCREEN_WIDTH", "1452")
            buildConfigField("int", "SCREEN_HEIGHT", "3132")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G710 MC10\"")
        }

        create("browser5") {
            dimension = "browser"
            applicationIdSuffix = ".vta2"
            versionNameSuffix = "-VTA2"
            resValue("string", "app_name", "Browser VTA2")
            buildConfigField("String", "PROFILE_ID", "\"profile_vta2_5\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; Pixel 8 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.6367.82 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Manila\"")
            buildConfigField("String", "LANGUAGE", "\"ms-MY\"")
            buildConfigField("int", "SCREEN_WIDTH", "1324")
            buildConfigField("int", "SCREEN_HEIGHT", "2976")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G715 Immortalis MC11\"")
        }

        create("browser6") {
            dimension = "browser"
            applicationIdSuffix = ".9yff"
            versionNameSuffix = "-9YFF"
            resValue("string", "app_name", "Browser 9YFF")
            buildConfigField("String", "PROFILE_ID", "\"profile_9yff_6\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; 2201116SG) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.108 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Seoul\"")
            buildConfigField("String", "LANGUAGE", "\"ru-RU\"")
            buildConfigField("int", "SCREEN_WIDTH", "1444")
            buildConfigField("int", "SCREEN_HEIGHT", "3204")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "12")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 730\"")
        }

        create("browser7") {
            dimension = "browser"
            applicationIdSuffix = ".1znf"
            versionNameSuffix = "-1ZNF"
            resValue("string", "app_name", "Browser 1ZNF")
            buildConfigField("String", "PROFILE_ID", "\"profile_1znf_7\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; V2254A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.116 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/New_York\"")
            buildConfigField("String", "LANGUAGE", "\"pl-PL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1248")
            buildConfigField("int", "SCREEN_HEIGHT", "2788")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Mali-G720 Immortalis MC12\"")
        }

        create("browser8") {
            dimension = "browser"
            applicationIdSuffix = ".wcdx"
            versionNameSuffix = "-WCDX"
            resValue("string", "app_name", "Browser WCDX")
            buildConfigField("String", "PROFILE_ID", "\"profile_wcdx_8\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; CPH2581) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.72 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Moscow\"")
            buildConfigField("String", "LANGUAGE", "\"nl-NL\"")
            buildConfigField("int", "SCREEN_WIDTH", "1456")
            buildConfigField("int", "SCREEN_HEIGHT", "3172")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "6")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser9") {
            dimension = "browser"
            applicationIdSuffix = ".0hwh"
            versionNameSuffix = "-0HWH"
            resValue("string", "app_name", "Browser 0HWH")
            buildConfigField("String", "PROFILE_ID", "\"profile_0hwh_9\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; 23127PN0CC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.69 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Rome\"")
            buildConfigField("String", "LANGUAGE", "\"pt-BR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1188")
            buildConfigField("int", "SCREEN_HEIGHT", "2688")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser10") {
            dimension = "browser"
            applicationIdSuffix = ".98y5"
            versionNameSuffix = "-98Y5"
            resValue("string", "app_name", "Browser 98Y5")
            buildConfigField("String", "PROFILE_ID", "\"profile_98y5_10\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; RMX3700) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.5938.154 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Denver\"")
            buildConfigField("String", "LANGUAGE", "\"pt-PT\"")
            buildConfigField("int", "SCREEN_WIDTH", "1244")
            buildConfigField("int", "SCREEN_HEIGHT", "2764")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser11") {
            dimension = "browser"
            applicationIdSuffix = ".kwjb"
            versionNameSuffix = "-KWJB"
            resValue("string", "app_name", "Browser KWJB")
            buildConfigField("String", "PROFILE_ID", "\"profile_kwjb_11\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; ASUS_AI2203) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.69 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Singapore\"")
            buildConfigField("String", "LANGUAGE", "\"ar-AE\"")
            buildConfigField("int", "SCREEN_WIDTH", "1064")
            buildConfigField("int", "SCREEN_HEIGHT", "2392")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser12") {
            dimension = "browser"
            applicationIdSuffix = ".brij"
            versionNameSuffix = "-BRIJ"
            resValue("string", "app_name", "Browser BRIJ")
            buildConfigField("String", "PROFILE_ID", "\"profile_brij_12\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; ASUS_AI2203) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.6613.84 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"America/Toronto\"")
            buildConfigField("String", "LANGUAGE", "\"zh-TW\"")
            buildConfigField("int", "SCREEN_WIDTH", "1060")
            buildConfigField("int", "SCREEN_HEIGHT", "2404")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "8")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 740\"")
        }

        create("browser13") {
            dimension = "browser"
            applicationIdSuffix = ".mpz4"
            versionNameSuffix = "-MPZ4"
            resValue("string", "app_name", "Browser MPZ4")
            buildConfigField("String", "PROFILE_ID", "\"profile_mpz4_13\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; 2304FPN6DC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.103 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Europe/Amsterdam\"")
            buildConfigField("String", "LANGUAGE", "\"it-IT\"")
            buildConfigField("int", "SCREEN_WIDTH", "1432")
            buildConfigField("int", "SCREEN_HEIGHT", "3196")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "6")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 750\"")
        }

        create("browser14") {
            dimension = "browser"
            applicationIdSuffix = ".c2qz"
            versionNameSuffix = "-C2QZ"
            resValue("string", "app_name", "Browser C2QZ")
            buildConfigField("String", "PROFILE_ID", "\"profile_c2qz_14\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 14; LE2121) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.113 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Pacific/Auckland\"")
            buildConfigField("String", "LANGUAGE", "\"tr-TR\"")
            buildConfigField("int", "SCREEN_WIDTH", "1424")
            buildConfigField("int", "SCREEN_HEIGHT", "3232")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "16")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "8")
            buildConfigField("String", "PLATFORM", "\"Linux armv81\"")
            buildConfigField("String", "VENDOR", "\"Google Inc.\"")
            buildConfigField("String", "RENDERER", "\"Adreno (TM) 660\"")
        }

        create("browser15") {
            dimension = "browser"
            applicationIdSuffix = ".5fel"
            versionNameSuffix = "-5FEL"
            resValue("string", "app_name", "Browser 5FEL")
            buildConfigField("String", "PROFILE_ID", "\"profile_5fel_15\"")
            buildConfigField("String", "USER_AGENT", "\"Mozilla/5.0 (Linux; Android 13; V2309) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.103 Mobile Safari/537.36\"")
            buildConfigField("String", "TIMEZONE", "\"Asia/Kuala_Lumpur\"")
            buildConfigField("String", "LANGUAGE", "\"ms-MY\"")
            buildConfigField("int", "SCREEN_WIDTH", "2180")
            buildConfigField("int", "SCREEN_HEIGHT", "2464")
            buildConfigField("int", "COLOR_DEPTH", "24")
            buildConfigField("int", "DEVICE_MEMORY", "4")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "4")
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
