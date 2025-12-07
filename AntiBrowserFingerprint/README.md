# Navigator - 15 Secure Browser Profiles

15 Android browser applications with unique fingerprinting protection profiles. Each Navigator browser spoofs different browser fingerprint parameters to prevent tracking and enhance privacy.

## Features

Each Navigator browser protects against:

### 1. Cookie & Storage Isolation
- Isolated storage per browser app
- Third-party cookies managed
- Session storage protection

### 2. Browser Fingerprinting Protection
- Custom User-Agent per browser
- Screen resolution spoofing
- Timezone customization
- Language settings
- Canvas fingerprint noise injection
- WebGL fingerprint protection
- Audio fingerprint noise

### 3. Device Fingerprinting
- Spoofed hardware concurrency
- Device memory masking
- Platform spoofing
- GPU/Vendor information masking

### 4. Network Fingerprinting
- Connection type spoofing
- WebRTC IP leak prevention
- Battery API spoofing

### 5. Behavior Tracking Protection
- Plugin enumeration prevention
- Font detection limitation

## Navigator Profiles

| Navigator | Device | Region | Language |
|-----------|--------|--------|----------|
| Navigator XN7K | Samsung Galaxy S21 | New York | English US |
| Navigator M4TZ | Google Pixel 9 | Berlin | German |
| Navigator P8WS | Xiaomi Redmi K40 | Shanghai | Chinese |
| Navigator R2HD | Vivo X90 Pro | Singapore | English SG |
| Navigator K9BV | Xiaomi 12 Pro | London | English UK |
| Navigator T5JX | Samsung Galaxy S23 Ultra | Los Angeles | English US |
| Navigator W3QP | OnePlus 8T | Kolkata | Hindi |
| Navigator N6FY | Realme GT Neo 5 | Manila | English PH |
| Navigator Z8CM | Google Pixel 8a | Chicago | Spanish US |
| Navigator V4DS | Motorola Moto G84 5G | Sao Paulo | Portuguese BR |
| Navigator H7GL | Samsung Galaxy A55 | Warsaw | Polish |
| Navigator B2RN | Xiaomi 12S Ultra | Seoul | Korean |
| Navigator C9EK | Huawei Pura 70 Pro | Ho Chi Minh | Vietnamese |
| Navigator F1AW | OnePlus 9 Pro | Paris | French |
| Navigator Q5UJ | Xiaomi 14 Ultra | Tokyo | Japanese |

## Building

### Prerequisites
- JDK 17 or higher
- Android SDK

### Local Build
```bash
# Build all browsers (debug)
./gradlew assembleDebug

# Build all browsers (release)
./gradlew assembleRelease

# Build specific browser
./gradlew assembleBrowser1Release
```

### Generate New Profiles
```bash
# Generate 15 new random profiles
python3 generate_profiles.py -n 15 --json profiles.json
```

### GitHub Actions
Push to `main` branch to trigger automatic build of all 15 APKs.

## Requirements

- Android 7.0 (API 24) or higher
- JDK 17 for building

## UI Design

Navigator features a modern dark theme with:
- Bottom toolbar for easy one-handed use
- Indigo/Purple color scheme
- Rounded URL bar with embedded search
- Sleek navigation icons

## License

MIT License
