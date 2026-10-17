package com.soltini.app.ui.theme

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Screen background for the active theme. Classic: the original brush, unchanged.
 * Blue Glass: icy blue gradient with soft white/cyan "cloud" glows like the reference design.
 * Pure gradients (no bitmaps), so it is cheap and scales to any screen size.
 */
@Composable
fun Modifier.myraBackground(): Modifier {
    val t = LocalMyraTokens.current
    if (t.mode != MyraThemeMode.BLUE_GLASS) return this.background(t.backgroundBrush)
    return this
        .background(t.backgroundBrush)
        .drawBehind {
            val w = size.width
            val h = size.height
            fun glow(c: Color, cx: Float, cy: Float, r: Float) =
                drawRect(Brush.radialGradient(listOf(c, Color.Transparent), center = Offset(w * cx, h * cy), radius = r))
            glow(Color(0x886DE0FD), 0.10f, 0.02f, w * 0.85f)   // cyan glow, top-left
            glow(Color(0xB3FFFFFF), 0.92f, 0.30f, w * 0.75f)   // white wisp, right
            glow(Color(0x99FFFFFF), 0.15f, 0.62f, w * 0.80f)   // white wisp, lower-left
            glow(Color(0x66A8D8FF), 0.85f, 0.95f, w * 0.80f)   // soft blue, bottom-right
        }
}
