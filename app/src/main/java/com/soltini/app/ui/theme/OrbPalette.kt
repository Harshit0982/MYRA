package com.soltini.app.ui.theme

/**
 * Hue mapping for the native (non-Compose) overlay orbs. Classic keeps the full rainbow ramp untouched;
 * Blue Glass squeezes it into the cyan-to-electric-blue range (about 190-235 degrees).
 * Reads the current theme at call time, so a freshly (re)created orb picks it up.
 */
object OrbPalette {
    fun hue(rainbowHue: Float): Float =
        if (ThemeController.mode.value == MyraThemeMode.BLUE_GLASS)
            190f + (rainbowHue.coerceIn(0f, 360f) / 360f) * 45f
        else rainbowHue
}
