package com.browser.antifingerprint.fingerprint

data class FingerprintProfile(
    val profileId: String,
    val userAgent: String,
    val timezone: String,
    val language: String,
    val screenWidth: Int,
    val screenHeight: Int,
    val colorDepth: Int,
    val deviceMemory: Int,
    val hardwareConcurrency: Int,
    val platform: String,
    val vendor: String,
    val renderer: String
) {
    val canvasNoise: Double
        get() = generateStableNoise("canvas")

    val audioNoise: Double
        get() = generateStableNoise("audio")

    val webglNoise: Double
        get() = generateStableNoise("webgl")

    private fun generateStableNoise(type: String): Double {
        val seed = "$profileId-$type".hashCode()
        val random = java.util.Random(seed.toLong())
        return random.nextDouble() * 0.0001
    }

    fun toJsonString(): String {
        return """
        {
            "profileId": "$profileId",
            "userAgent": "$userAgent",
            "timezone": "$timezone",
            "language": "$language",
            "languages": ["$language", "${language.split("-")[0]}"],
            "screenWidth": $screenWidth,
            "screenHeight": $screenHeight,
            "availWidth": $screenWidth,
            "availHeight": ${screenHeight - 80},
            "colorDepth": $colorDepth,
            "pixelDepth": $colorDepth,
            "deviceMemory": $deviceMemory,
            "hardwareConcurrency": $hardwareConcurrency,
            "platform": "$platform",
            "vendor": "$vendor",
            "renderer": "$renderer",
            "canvasNoise": $canvasNoise,
            "audioNoise": $audioNoise,
            "webglNoise": $webglNoise
        }
        """.trimIndent()
    }
}
