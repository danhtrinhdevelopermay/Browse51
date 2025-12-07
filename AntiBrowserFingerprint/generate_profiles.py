#!/usr/bin/env python3
import random
import string
import hashlib
import json
import os

DEVICES = [
    {"model": "SM-S928B", "name": "Samsung Galaxy S24 Ultra", "renderer": "Adreno (TM) 750", "width": 1440, "height": 3120},
    {"model": "SM-S918B", "name": "Samsung Galaxy S23 Ultra", "renderer": "Adreno (TM) 740", "width": 1440, "height": 3088},
    {"model": "SM-S908B", "name": "Samsung Galaxy S22 Ultra", "renderer": "Adreno (TM) 730", "width": 1440, "height": 3088},
    {"model": "SM-A546B", "name": "Samsung Galaxy A54", "renderer": "Mali-G68 MC4", "width": 1080, "height": 2340},
    {"model": "SM-A346B", "name": "Samsung Galaxy A34", "renderer": "Mali-G68 MC4", "width": 1080, "height": 2340},
    {"model": "Pixel 8 Pro", "name": "Google Pixel 8 Pro", "renderer": "Mali-G715 Immortalis MC11", "width": 1344, "height": 2992},
    {"model": "Pixel 8", "name": "Google Pixel 8", "renderer": "Mali-G715 Immortalis MC11", "width": 1080, "height": 2400},
    {"model": "Pixel 7 Pro", "name": "Google Pixel 7 Pro", "renderer": "Mali-G710 MC10", "width": 1440, "height": 3120},
    {"model": "Pixel 7", "name": "Google Pixel 7", "renderer": "Mali-G710 MC10", "width": 1080, "height": 2400},
    {"model": "Pixel 6 Pro", "name": "Google Pixel 6 Pro", "renderer": "Mali-G78 MP20", "width": 1440, "height": 3120},
    {"model": "2201116SG", "name": "Xiaomi 12S Ultra", "renderer": "Adreno (TM) 730", "width": 1440, "height": 3200},
    {"model": "2304FPN6DC", "name": "Xiaomi 14 Ultra", "renderer": "Adreno (TM) 750", "width": 1440, "height": 3200},
    {"model": "23127PN0CC", "name": "Xiaomi 14", "renderer": "Adreno (TM) 750", "width": 1200, "height": 2670},
    {"model": "M2102K1G", "name": "Xiaomi Mi 11 Ultra", "renderer": "Adreno (TM) 660", "width": 1440, "height": 3200},
    {"model": "CPH2581", "name": "Oppo Find X7 Ultra", "renderer": "Adreno (TM) 750", "width": 1440, "height": 3168},
    {"model": "CPH2557", "name": "Oppo Find N3", "renderer": "Adreno (TM) 740", "width": 1792, "height": 1920},
    {"model": "V2254A", "name": "Vivo X100 Pro", "renderer": "Mali-G720 Immortalis MC12", "width": 1260, "height": 2800},
    {"model": "V2309", "name": "Vivo X Fold3 Pro", "renderer": "Adreno (TM) 750", "width": 2200, "height": 2480},
    {"model": "XQ-DQ72", "name": "Sony Xperia 1 V", "renderer": "Adreno (TM) 740", "width": 1644, "height": 3840},
    {"model": "XQ-DE72", "name": "Sony Xperia 5 V", "renderer": "Adreno (TM) 740", "width": 1080, "height": 2520},
    {"model": "ASUS_AI2401_A", "name": "Asus ROG Phone 8 Pro", "renderer": "Adreno (TM) 750", "width": 1080, "height": 2400},
    {"model": "ASUS_AI2203", "name": "Asus Zenfone 10", "renderer": "Adreno (TM) 740", "width": 1080, "height": 2400},
    {"model": "LE2121", "name": "OnePlus 9 Pro", "renderer": "Adreno (TM) 660", "width": 1440, "height": 3216},
    {"model": "CPH2449", "name": "OnePlus 11", "renderer": "Adreno (TM) 740", "width": 1440, "height": 3216},
    {"model": "CPH2551", "name": "OnePlus 12", "renderer": "Adreno (TM) 750", "width": 1440, "height": 3168},
    {"model": "moto g84 5G", "name": "Motorola Moto G84", "renderer": "Adreno (TM) 619", "width": 1080, "height": 2400},
    {"model": "moto edge 40 pro", "name": "Motorola Edge 40 Pro", "renderer": "Adreno (TM) 740", "width": 1220, "height": 2712},
    {"model": "RMX3700", "name": "Realme GT5 Pro", "renderer": "Adreno (TM) 750", "width": 1264, "height": 2780},
    {"model": "RMX3661", "name": "Realme GT Neo 5", "renderer": "Adreno (TM) 740", "width": 1240, "height": 2772},
    {"model": "NE2213", "name": "OnePlus Nord 2T", "renderer": "Mali-G77 MC9", "width": 1080, "height": 2400},
]

TIMEZONES = [
    "America/New_York", "America/Los_Angeles", "America/Chicago", "America/Denver",
    "America/Toronto", "America/Vancouver", "America/Sao_Paulo", "America/Mexico_City",
    "Europe/London", "Europe/Paris", "Europe/Berlin", "Europe/Madrid", "Europe/Rome",
    "Europe/Amsterdam", "Europe/Moscow", "Europe/Warsaw", "Europe/Stockholm",
    "Asia/Tokyo", "Asia/Seoul", "Asia/Shanghai", "Asia/Hong_Kong", "Asia/Singapore",
    "Asia/Bangkok", "Asia/Jakarta", "Asia/Ho_Chi_Minh", "Asia/Manila", "Asia/Dubai",
    "Asia/Kolkata", "Asia/Taipei", "Asia/Kuala_Lumpur",
    "Australia/Sydney", "Australia/Melbourne", "Pacific/Auckland",
]

LANGUAGES = [
    ("en-US", "English (US)"), ("en-GB", "English (UK)"), ("en-AU", "English (Australia)"),
    ("es-ES", "Spanish (Spain)"), ("es-MX", "Spanish (Mexico)"), ("pt-BR", "Portuguese (Brazil)"),
    ("pt-PT", "Portuguese (Portugal)"), ("fr-FR", "French"), ("de-DE", "German"),
    ("it-IT", "Italian"), ("nl-NL", "Dutch"), ("pl-PL", "Polish"), ("ru-RU", "Russian"),
    ("ja-JP", "Japanese"), ("ko-KR", "Korean"), ("zh-CN", "Chinese (Simplified)"),
    ("zh-TW", "Chinese (Traditional)"), ("th-TH", "Thai"), ("vi-VN", "Vietnamese"),
    ("id-ID", "Indonesian"), ("ms-MY", "Malay"), ("ar-AE", "Arabic (UAE)"),
    ("hi-IN", "Hindi"), ("tr-TR", "Turkish"), ("sv-SE", "Swedish"),
]

CHROME_VERSIONS = [
    # Chrome 115
    "115.0.5790.166", "115.0.5790.138", "115.0.5790.110",
    # Chrome 116
    "116.0.5845.163", "116.0.5845.114", "116.0.5845.96",
    # Chrome 117
    "117.0.5938.154", "117.0.5938.140", "117.0.5938.117", "117.0.5938.92",
    # Chrome 118
    "118.0.5993.111", "118.0.5993.80", "118.0.5993.65",
    # Chrome 119
    "119.0.6045.193", "119.0.6045.169", "119.0.6045.134", "119.0.6045.109",
    # Chrome 120
    "120.0.6099.230", "120.0.6099.210", "120.0.6099.193", "120.0.6099.144", "120.0.6099.116", "120.0.6099.85",
    # Chrome 121
    "121.0.6167.178", "121.0.6167.164", "121.0.6167.143", "121.0.6167.101", "121.0.6167.85", "121.0.6167.57",
    # Chrome 122
    "122.0.6261.128", "122.0.6261.119", "122.0.6261.105", "122.0.6261.90", "122.0.6261.64", "122.0.6261.43",
    # Chrome 123
    "123.0.6312.118", "123.0.6312.99", "123.0.6312.80", "123.0.6312.58", "123.0.6312.40",
    # Chrome 124
    "124.0.6367.179", "124.0.6367.155", "124.0.6367.113", "124.0.6367.82", "124.0.6367.60",
    # Chrome 125
    "125.0.6422.165", "125.0.6422.144", "125.0.6422.113", "125.0.6422.72", "125.0.6422.53",
    # Chrome 126
    "126.0.6478.122", "126.0.6478.110", "126.0.6478.72", "126.0.6478.50",
    # Chrome 127
    "127.0.6533.103", "127.0.6533.88", "127.0.6533.72", "127.0.6533.57",
    # Chrome 128
    "128.0.6613.127", "128.0.6613.114", "128.0.6613.84", "128.0.6613.66",
    # Chrome 129
    "129.0.6668.100", "129.0.6668.89", "129.0.6668.70", "129.0.6668.54",
    # Chrome 130
    "130.0.6723.116", "130.0.6723.102", "130.0.6723.69", "130.0.6723.40",
    # Chrome 131
    "131.0.6778.135", "131.0.6778.108", "131.0.6778.81", "131.0.6778.69",
]

ANDROID_VERSIONS = [13, 14]

MEMORY_OPTIONS = [4, 6, 8, 12, 16, 24]
CORE_OPTIONS = [4, 6, 8]

def generate_random_suffix(length=4):
    chars = string.ascii_lowercase + string.digits
    return ''.join(random.choice(chars) for _ in range(length))

def add_screen_noise(width, height, noise_range=20):
    """Add random noise to screen dimensions (±noise_range pixels)"""
    width_noise = random.randint(-noise_range, noise_range)
    height_noise = random.randint(-noise_range, noise_range)
    # Keep values divisible by 4 for realistic screen dimensions
    new_width = ((width + width_noise) // 4) * 4
    new_height = ((height + height_noise) // 4) * 4
    return new_width, new_height

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
        
        # Add noise to screen dimensions
        screen_width, screen_height = add_screen_noise(device["width"], device["height"])
        
        # Create user agent
        user_agent = f"Mozilla/5.0 (Linux; Android {android_version}; {device['model']}) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/{chrome_version} Mobile Safari/537.36"
        
        # Check for unique combination (device + timezone + language + screen + memory + cores)
        combo_hash = hashlib.md5(
            f"{device['model']}-{timezone}-{language}-{screen_width}x{screen_height}-{memory}-{cores}".encode()
        ).hexdigest()[:12]
        
        # Also ensure user agent is unique
        if combo_hash not in used_combos and user_agent not in used_user_agents:
            used_combos.add(combo_hash)
            used_user_agents.add(user_agent)
            break
    
    suffix = generate_random_suffix()
    
    return {
        "index": index,
        "suffix": suffix,
        "profile_id": f"profile_{suffix}_{index}",
        "app_name": f"Browser {suffix.upper()}",
        "user_agent": user_agent,
        "timezone": timezone,
        "language": language,
        "screen_width": screen_width,
        "screen_height": screen_height,
        "color_depth": 24,
        "device_memory": memory,
        "hardware_concurrency": cores,
        "platform": "Linux armv81",
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
        applicationId = "com.browser.antifingerprint"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    parser = argparse.ArgumentParser(description='Generate random browser profiles')
    parser.add_argument('-n', '--num', type=int, default=10, help='Number of browsers to generate (default: 10)')
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
    
    print(f"Generated {args.num} unique browser profiles!")
    print(f"Output written to: {output_path}")
    print("\nGenerated profiles:")
    for p in profiles:
        print(f"  - Browser {p['index']}: {p['suffix']} | {p['device_name']} | {p['timezone']} | {p['language']}")
    
    if args.json:
        json_path = os.path.join(script_dir, args.json)
        with open(json_path, 'w') as f:
            json.dump(profiles, f, indent=2)
        print(f"\nProfiles also saved to: {json_path}")
    
    print(f"\nTo build all browsers: ./gradlew assembleDebug")
    print(f"To build specific browser: ./gradlew assembleBrowser1Debug")

if __name__ == "__main__":
    main()
