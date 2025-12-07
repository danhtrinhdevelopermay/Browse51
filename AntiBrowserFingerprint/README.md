# Anti-Browser Fingerprint - 10 Secure Browsers

10 Android browser applications with unique fingerprinting protection profiles. Each browser spoofs different browser fingerprint parameters to prevent tracking.

## Features

Each browser protects against:

### 1. Cookie & LocalStorage
- Isolated storage per browser app
- Third-party cookies blocked
- Session storage protection

### 2. Browser Fingerprinting
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

## Browser Profiles

| Browser | Device | Region | Language |
|---------|--------|--------|----------|
| Browser 1 | Pixel 8 Pro | New York | English US |
| Browser 2 | Galaxy S23 | London | English UK |
| Browser 3 | OnePlus 12 | Tokyo | Japanese |
| Browser 4 | Xiaomi 14 Pro | Shanghai | Chinese |
| Browser 5 | OPPO Find X7 | Paris | French |
| Browser 6 | Sony Xperia 1 V | Berlin | German |
| Browser 7 | Huawei Mate 60 | Dubai | Arabic |
| Browser 8 | Vivo X100 Pro | Ho Chi Minh | Vietnamese |
| Browser 9 | ASUS ROG Phone 8 | Singapore | English SG |
| Browser 10 | Motorola Edge 40 | Sao Paulo | Portuguese BR |

## Building

### Local Build
```bash
./gradlew assembleRelease
```

### GitHub Actions
Push to `main` branch to trigger automatic build of all 10 APKs.

## Requirements

- Android 7.0 (API 24) or higher
- JDK 17 for building

## License

MIT License
