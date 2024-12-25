package com.compose.showcase.ui.composables

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.compose.showcase.ui.theme.PurpleDark
import com.compose.showcase.ui.theme.ShowcaseTheme
import com.compose.showcase.ui.theme.SunriseOrange
import com.compose.showcase.ui.theme.SunriseRed

@Composable
internal fun IsoCircleButton(
    containerColors: List<Color> = listOf(SunriseOrange, SunriseRed),
    containerSize: Dp = 56.dp,
    borderColor: Color = PurpleDark,
    borderWidth: Dp = 2.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val depthPx = with(LocalDensity.current) {
        containerSize.toPx() * 0.1F
    }
    val animatedDepthPx by animateFloatAsState(
        targetValue = if (isPressed) depthPx else 0F,
        animationSpec = if (isPressed) {
            tween(50, easing = EaseInOut)
        } else {
            tween(150, easing = EaseInOut)
        },
        label = "Press animation",
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(containerSize),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset {
                    IntOffset(
                        x = -depthPx.toInt(),
                        y = depthPx.toInt(),
                    )
                }
                .rotate(degrees = -45F)
                .circleButtonSpecs(
                    borderColor = borderColor,
                    borderWidth = borderWidth,
                    containerBrush = Brush.verticalGradient(containerColors),
                ),
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .offset {
                    IntOffset(
                        x = -animatedDepthPx.toInt(),
                        y = animatedDepthPx.toInt(),
                    )
                }
                .circleButtonSpecs(
                    borderColor = borderColor,
                    borderWidth = borderWidth,
                    containerBrush = Brush.verticalGradient(containerColors),
                )
                .pointerInput(Unit) {
                    detectTapGestures(onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    })
                },
        ) {
            content()
        }
    }
}

private fun Modifier.circleButtonSpecs(
    borderColor: Color,
    borderWidth: Dp,
    containerBrush: Brush,
): Modifier {
    return this
        .clip(CircleShape)
        .background(borderColor)
        .padding(borderWidth)
        .clip(CircleShape)
        .background(containerBrush)
}

@Preview(showBackground = false)
@Composable
fun IsoCircleButtonPreview() {
    ShowcaseTheme {
        IsoCircleButton(containerSize = 56.dp) {
            Box(
                modifier = Modifier,
            )
        }
    }
}
