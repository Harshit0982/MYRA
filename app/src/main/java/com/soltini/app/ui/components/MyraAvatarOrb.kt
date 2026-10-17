package com.soltini.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Glossy blue sphere used as MYRA's avatar in Blue Glass headers and chat (static, no animation cost). */
@Composable
fun MyraAvatarOrb(size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(size)
            .shadow(6.dp, CircleShape, ambientColor = Color(0xFF35B6FD), spotColor = Color(0xFF2C7FFC))
            .clip(CircleShape)
            .background(
                Brush.radialGradient(
                    listOf(Color(0xFFE3FBFF), Color(0xFF6FD0FF), Color(0xFF2C7FFC), Color(0xFF1B55D6))
                )
            )
            .border(BorderStroke(2.dp, Color(0xCCFFFFFF)), CircleShape)
    )
}
