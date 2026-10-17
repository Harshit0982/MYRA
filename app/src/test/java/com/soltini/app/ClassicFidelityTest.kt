package com.soltini.app

import androidx.compose.ui.unit.dp
import com.soltini.app.ui.theme.ClassicTokens
import com.soltini.app.ui.theme.GlassCardWhite
import com.soltini.app.ui.theme.PrimaryPink
import com.soltini.app.ui.theme.PrimaryPurple
import com.soltini.app.ui.theme.TextCharcoal
import com.soltini.app.ui.theme.TextMidGray
import com.soltini.app.ui.theme.PrimaryGradientBrush
import com.soltini.app.ui.theme.PrimaryHorizontalBrush
import com.soltini.app.ui.theme.SoftBackgroundBrush
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test

/** Guards the "Classic must stay visually identical" requirement: Classic tokens are the original constants. */
class ClassicFidelityTest {
    @Test fun `classic tokens are the original constants`() {
        assertEquals(PrimaryPurple, ClassicTokens.accent)
        assertEquals(PrimaryPink, ClassicTokens.accentSecondary)
        assertEquals(PrimaryPurple, ClassicTokens.shadowColor)
        assertEquals(TextCharcoal, ClassicTokens.textPrimary)
        assertEquals(TextMidGray, ClassicTokens.textSecondary)
        assertEquals(GlassCardWhite, ClassicTokens.cardColor)
        assertEquals(24.dp, ClassicTokens.cardCornerRadius)
        assertNull(ClassicTokens.cardBorder)
        assertSame(SoftBackgroundBrush, ClassicTokens.backgroundBrush)
        assertSame(PrimaryGradientBrush, ClassicTokens.accentGradient)
        assertSame(PrimaryHorizontalBrush, ClassicTokens.accentHorizontalGradient)
    }
}
