#!/usr/bin/env python3
import random
import string
import hashlib
import json
import os

DEVICES = [
    {"model": "SM-G991B", "name": "Samsung Galaxy S21", "renderer": "Adreno (TM) 660", "width": 1080, "height": 2400},
    {"model": "SM-S918B", "name": "Samsung Galaxy S23 Ultra", "renderer": "Adreno (TM) 740", "width": 1440, "height": 3088},
    {"model": "SM-A556B", "name": "Samsung Galaxy A55", "renderer": "Mali-G68 MC4", "width": 1080, "height": 2340},
    {"model": "Pixel 9", "name": "Google Pixel 9", "renderer": "Mali-G715 Immortalis MC11", "width": 1080, "height": 2424},
    {"model": "Pixel 8a", "name": "Google Pixel 8a", "renderer": "Mali-G715 MC7", "width": 1080, "height": 2400},
    {"model": "M2101K6G", "name": "Xiaomi Redmi K40", "renderer": "Adreno (TM) 650", "width": 1080, "height": 2400},
    {"model": "2312DRA50G", "name": "Xiaomi 14 Ultra", "renderer": "Adreno (TM) 750", "width": 1440, "height": 3200},
    {"model": "22071212AG", "name": "Xiaomi 12S Ultra", "renderer": "Adreno (TM) 730", "width": 1220, "height": 2712},
    {"model": "V2254A", "name": "Vivo X90 Pro", "renderer": "Adreno (TM) 740", "width": 1260, "height": 2800},
    {"model": "2201117TG", "name": "Xiaomi 12 Pro", "renderer": "Adreno (TM) 730", "width": 1220, "height": 2712},
    {"model": "KB2001", "name": "OnePlus 8T", "renderer": "Adreno (TM) 650", "width": 1080, "height": 2400},
    {"model": "LE2115", "name": "OnePlus 9 Pro", "renderer": "Adreno (TM) 660", "width": 1440, "height": 3216},
    {"model": "RMX3710", "name": "Realme GT Neo 5", "renderer": "Mali-G77 MC9", "width": 1240, "height": 2772},
    {"model": "PHB110", "name": "Huawei Pura 70 Pro", "renderer": "Adreno (TM) 750", "width": 1264, "height": 2780},
    {"model": "moto g84 5G", "name": "Motorola Moto G84 5G", "renderer": "Adreno (TM) 619", "width": 1080, "height": 2400},
]

TIMEZONES = [
    "America/New_York", "America/Los_Angeles", "America/Chicago", "America/Denver",
    "America/Sao_Paulo", "America/Mexico_City",
    "Europe/London", "Europe/Paris", "Europe/Berlin", "Europe/Warsaw", "Europe/Rome",
    "Asia/Tokyo", "Asia/Seoul", "Asia/Shanghai", "Asia/Singapore",
    "Asia/Bangkok", "Asia/Jakarta", "Asia/Ho_Chi_Minh", "Asia/Manila", "Asia/Kolkata",
    "Australia/Sydney", "Pacific/Auckland",
]

LANGUAGES = [
    ("en-US", "English (US)"), ("en-GB", "English (UK)"), ("en-SG", "English (Singapore)"),
    ("en-PH", "English (Philippines)"),
    ("es-US", "Spanish (US)"), ("pt-BR", "Portuguese (Brazil)"),
    ("fr-FR", "French"), ("de-DE", "German"),
    ("pl-PL", "Polish"),
    ("ja-JP", "Japanese"), ("ko-KR", "Korean"), ("zh-CN", "Chinese (Simplified)"),
    ("vi-VN", "Vietnamese"), ("hi-IN", "Hindi"),
]

CHROME_VERSIONS = [
    "124.0.6367.82", "125.0.6422.165",
    "126.0.6478.186", "127.0.6533.103",
    "128.0.6613.127", "128.0.6613.88",
    "129.0.6668.89", "129.0.6668.54",
    "130.0.6723.58", "130.0.6723.40",
    "131.0.6778.200", "131.0.6778.135", "131.0.6778.104",
    "132.0.6834.79", "132.0.6834.15",
]

ANDROID_VERSIONS = [13, 14]

MEMORY_OPTIONS = [8, 12, 16]
CORE_OPTIONS = [8]

def generate_random_suffix(length=4):
    first_char = random.choice(string.ascii_lowercase)
    rest_chars = ''.join(random.choice(string.ascii_lowercase + string.digits) for _ in range(length - 1))
    return first_char + rest_chars

def generate_profile(index, used_combos, used_user_agents):
    max_attempts = 100
    attempts = 0
    
    while attempts < max_attempts:
        attempts += 1
        device = random.choice(DEVICES)
        timezone = random.choice(TIMEZONES)
        language = random.choice(LANGUAGES)[0]
        chrome_version = random.choice(CHROME_VERSIONS)
        android_version = random.choice(ANDROID_VERSIONS)
        memory = random.choice(MEMORY_OPTIONS)
        cores = random.choice(CORE_OPTIONS)
        
        screen_width = device["width"]
        screen_height = device["height"]
        
        user_agent = f"Mozilla/5.0 (Linux; Android {android_version}; {device['model']}) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/{chrome_version} Mobile Safari/537.36"
        
        combo_hash = hashlib.md5(
            f"{device['model']}-{timezone}-{language}-{screen_width}x{screen_height}-{memory}-{cores}".encode()
        ).hexdigest()[:12]
        
        if combo_hash not in used_combos and user_agent not in used_user_agents:
            used_combos.add(combo_hash)
            used_user_agents.add(user_agent)
            break
    
    suffix = generate_random_suffix()
    
    return {
        "index": index,
        "suffix": suffix,
        "profile_id": f"nav_{suffix}_{index}",
        "app_name": f"Navigator {suffix.upper()}",
        "user_agent": user_agent,
        "timezone": timezone,
        "language": language,
        "screen_width": screen_width,
        "screen_height": screen_height,
        "color_depth": 24,
        "device_memory": memory,
        "hardware_concurrency": cores,
        "platform": "Linux armv8l",
        "vendor": "Google Inc.",
        "renderer": device["renderer"],
        "device_name": device["name"],
        "chrome_version": chrome_version,
    }

def generate_flavor_code(profile):
    return f'''
        create("browser{profile['index']}") {{
            dimension = "browser"
            applicationIdSuffix = ".{profile['suffix']}"
            versionNameSuffix = "-{profile['suffix'].upper()}"
            resValue("string", "app_name", "{profile['app_name']}")
            buildConfigField("String", "PROFILE_ID", "\\"{profile['profile_id']}\\"")
            buildConfigField("String", "USER_AGENT", "\\"{profile['user_agent']}\\"")
            buildConfigField("String", "TIMEZONE", "\\"{profile['timezone']}\\"")
            buildConfigField("String", "LANGUAGE", "\\"{profile['language']}\\"")
            buildConfigField("int", "SCREEN_WIDTH", "{profile['screen_width']}")
            buildConfigField("int", "SCREEN_HEIGHT", "{profile['screen_height']}")
            buildConfigField("int", "COLOR_DEPTH", "{profile['color_depth']}")
            buildConfigField("int", "DEVICE_MEMORY", "{profile['device_memory']}")
            buildConfigField("int", "HARDWARE_CONCURRENCY", "{profile['hardware_concurrency']}")
            buildConfigField("String", "PLATFORM", "\\"{profile['platform']}\\"")
            buildConfigField("String", "VENDOR", "\\"{profile['vendor']}\\"")
            buildConfigField("String", "RENDERER", "\\"{profile['renderer']}\\"")
        }}
'''

def generate_build_gradle(profiles, num_browsers):
    flavors_code = ""
    for profile in profiles:
        flavors_code += generate_flavor_code(profile)
    
    return f'''plugins {{
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}}

android {{
    namespace = "com.browser.antifingerprint"
    compileSdk = 34

    defaultConfig {{
        applicationId = "com.navigator.browser"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }}

    signingConfigs {{
        create("release") {{
            storeFile = file("keystore/release.keystore")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "android"
            keyAlias = System.getenv("KEY_ALIAS") ?: "key0"
            keyPassword = System.getenv("KEY_PASSWORD") ?: "android"
        }}
    }}

    buildTypes {{
        release {{
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }}
        debug {{
            isMinifyEnabled = false
        }}
    }}

    flavorDimensions += "browser"

    productFlavors {{{flavors_code}    }}

    compileOptions {{
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }}

    kotlinOptions {{
        jvmTarget = "17"
    }}

    buildFeatures {{
        viewBinding = true
        buildConfig = true
    }}
}}

dependencies {{
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.webkit:webkit:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}}
'''

def main():
    import argparse
    parser = argparse.ArgumentParser(description='Generate random Navigator browser profiles')
    parser.add_argument('-n', '--num', type=int, default=15, help='Number of browsers to generate (default: 15)')
    parser.add_argument('-o', '--output', type=str, default='app/build.gradle.kts', help='Output file path')
    parser.add_argument('--json', type=str, help='Also save profiles to JSON file')
    args = parser.parse_args()
    
    used_combos = set()
    used_user_agents = set()
    profiles = []
    
    for i in range(1, args.num + 1):
        profile = generate_profile(i, used_combos, used_user_agents)
        profiles.append(profile)
    
    gradle_content = generate_build_gradle(profiles, args.num)
    
    script_dir = os.path.dirname(os.path.abspath(__file__))
    output_path = os.path.join(script_dir, args.output)
    
    with open(output_path, 'w') as f:
        f.write(gradle_content)
    
    print(f"Generated {args.num} unique Navigator browser profiles!")
    print(f"Output written to: {output_path}")
    print("\nGenerated profiles:")
    for p in profiles:
        print(f"  - Navigator {p['index']}: {p['suffix']} | {p['device_name']} | {p['timezone']} | {p['language']}")
    
    if args.json:
        json_path = os.path.join(script_dir, args.json)
        with open(json_path, 'w') as f:
            json.dump(profiles, f, indent=2)
        print(f"\nProfiles also saved to: {json_path}")
    
    print(f"\nTo build all browsers: ./gradlew assembleDebug")
    print(f"To build specific browser: ./gradlew assembleBrowser1Debug")

if __name__ == "__main__":
    main()
