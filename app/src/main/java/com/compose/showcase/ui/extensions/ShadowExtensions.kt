package com.compose.showcase.ui.extensions

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.shadowLarge(
    shape: Shape,
    color: Color,
): Modifier {
    return dropShadow(shape = shape, color = color.copy(alpha = 0.013F), blur = 1.8.dp, yOffset = (-0.43).dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.04F), blur = 4.32.dp, yOffset = 0.38.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.073F), blur = 8.14.dp, yOffset = 3.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.085F), blur = 14.52.dp, yOffset = 8.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.10F), blur = 27.16.dp, yOffset = 15.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.17F), blur = 65.dp, yOffset = 50.dp)
}

fun Modifier.shadowMedium(
    shape: Shape,
    color: Color,
): Modifier {
    return dropShadow(shape = shape, color = color.copy(alpha = 0.008F), blur = 1.33.dp, yOffset = 0.6.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.026F), blur = 2.5.dp, yOffset = 1.13.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.05F), blur = 4.47.dp, yOffset = 2.01.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.083F), blur = 8.36.dp, yOffset = 3.76.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.14F), blur = 20.dp, yOffset = 9.dp)
}

fun Modifier.shadowSmall(
    shape: Shape,
    color: Color,
): Modifier {
    return dropShadow(shape = shape, color = color.copy(alpha = 0.006F), blur = 0.47.dp, yOffset = 0.4.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.018F), blur = 0.88.dp, yOffset = 0.75.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.036F), blur = 1.56.dp, yOffset = 1.34.dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.06F), blur = 2.dp, yOffset = (-0.5).dp)
        .dropShadow(shape = shape, color = color.copy(alpha = 0.10F), blur = 5.dp, yOffset = 4.dp)
}

/**
 * Custom shadow modifier that allows to add a shadow to a composable based on Figma specs.
 */
private fun Modifier.dropShadow(
    shape: Shape,
    color: Color = Color.Black,
    blur: Dp = 12.dp,
    spread: Dp = 0.dp,
    yOffset: Dp = 0.dp,
    xOffset: Dp = 0.dp,
): Modifier {
    return drawWithCache {
        val blurPx = blur.toPx()
        val spreadPx = spread.toPx()
        val yOffsetPx = yOffset.toPx()
        val xOffsetPx = xOffset.toPx()

        val paint = Paint().apply {
            this.color = color
        }

        if (blurPx > 0) {
            paint.asFrameworkPaint().apply {
                maskFilter = BlurMaskFilter(blurPx, BlurMaskFilter.Blur.NORMAL)
            }
        }

        val shadowSize = Size(
            width = size.width + spreadPx,
            height = size.height + spreadPx,
        )

        val shadowOutline = shape.createOutline(
            size = shadowSize,
            layoutDirection = layoutDirection,
            density = this,
        )

        onDrawWithContent {
            drawIntoCanvas { canvas ->
                canvas.save()
                canvas.translate(xOffsetPx, yOffsetPx)
                canvas.drawOutline(shadowOutline, paint)
                canvas.restore()
            }
            drawContent()
        }
    }
}
