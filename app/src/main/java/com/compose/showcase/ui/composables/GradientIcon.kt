package com.compose.showcase.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy.Companion.Offscreen
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter

@Composable
internal fun GradientIcon(
    painter: Painter,
    gradientColors: List<Color>,
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .graphicsLayer { compositingStrategy = Offscreen }
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    drawRect(
                        Brush.verticalGradient(gradientColors),
                        blendMode = BlendMode.SrcAtop,
                    )
                }
            },
    )
}
