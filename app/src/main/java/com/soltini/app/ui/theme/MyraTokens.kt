package com.soltini.app.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Presentation tokens for the active theme. Screens/components read these through [LocalMyraTokens]
 * instead of importing raw colors, so one component can serve both themes.
 *
 * CLASSIC tokens are mapped 1:1 onto the pre-existing colors/values, so Classic stays visually identical.
 */
@Immutable
data class MyraTokens(
    val mode: MyraThemeMode,
    val backgroundBrush: Brush,
    val accent: Color,
    val accentSecondary: Color,
    val accentGradient: Brush,
    val accentHorizontalGradient: Brush,
    val textPrimary: Color,
    val textSecondary: Color,
    val cardColor: Color,
    val cardBorder: BorderStroke?,
    val shadowColor: Color,
    val cardCornerRadius: Dp,
    val subtleSurface: Color,
    val switchOnTrack: Color,
    val switchOffTrack: Color,
    val navUnselected: Color
)

val ClassicTokens = MyraTokens(
    mode = MyraThemeMode.CLASSIC,
    backgroundBrush = SoftBackgroundBrush,
    accent = PrimaryPurple,
    accentSecondary = PrimaryPink,
    accentGradient = PrimaryGradientBrush,
    accentHorizontalGradient = PrimaryHorizontalBrush,
    textPrimary = TextCharcoal,
    textSecondary = TextMidGray,
    cardColor = GlassCardWhite,
    cardBorder = null,
    shadowColor = PrimaryPurple,
    cardCornerRadius = 24.dp,
    subtleSurface = GlassSurfaceSubtle,
    switchOnTrack = SecondaryMint,
    switchOffTrack = Color(0xFFDCD9E6),
    navUnselected = TextMidGray
)

// Blue Glass palette (starting values from the redesign brief)
val BluePrimary = Color(0xFF2C7FFC)      // sampled: enrollment button / toggle ON
val BlueElectricCyan = Color(0xFF35B6FD) // sampled: mic ring / orb glow
val BlueDeep = Color(0xFF1F5FE6)
val BlueIceBackground = Color(0xFFD6ECFC)
val BluePaleCyanSurface = Color(0xFFE7F5FD)
val BlueTextPrimary = Color(0xFF0F2547)
val BlueTextSecondary = Color(0xFF5F7594)

val BlueGlassBackgroundBrush: Brush = Brush.verticalGradient(
    colors = listOf(Color(0xFFBFE1FC), Color(0xFFD6ECFC), Color(0xFFE7F5FD), Color(0xFFD3EAFB))
)

val BlueGlassTokens = MyraTokens(
    mode = MyraThemeMode.BLUE_GLASS,
    backgroundBrush = BlueGlassBackgroundBrush,
    accent = BluePrimary,
    accentSecondary = BlueElectricCyan,
    accentGradient = Brush.linearGradient(listOf(Color(0xFF2368F0), Color(0xFF3FA3FF))),
    accentHorizontalGradient = Brush.horizontalGradient(listOf(Color(0xFF2368F0), Color(0xFF3E9BFD))),
    textPrimary = BlueTextPrimary,
    textSecondary = BlueTextSecondary,
    cardColor = Color(0xCCFFFFFF),                     // ~80% white: frosted, lets the blue show through
    cardBorder = BorderStroke(1.dp, Color(0xE6FFFFFF)), // bright white glass edge
    shadowColor = Color(0xFF5B9BE8),
    cardCornerRadius = 22.dp,
    subtleSurface = Color(0x99FFFFFF),
    switchOnTrack = BluePrimary,
    switchOffTrack = Color(0xFFCBD8EE),
    navUnselected = Color(0xFF5B6E8C)
)

fun tokensFor(mode: MyraThemeMode): MyraTokens = when (mode) {
    MyraThemeMode.CLASSIC -> ClassicTokens
    MyraThemeMode.BLUE_GLASS -> BlueGlassTokens
}

/** Defaults to Classic so any composable rendered outside GeminiVoiceTheme (previews, tests) looks as before. */
val LocalMyraTokens = compositionLocalOf { ClassicTokens }
