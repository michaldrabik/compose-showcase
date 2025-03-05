package com.compose.showcase.ui.composables

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.compose.showcase.ui.theme.PurpleDark
import com.compose.showcase.ui.theme.PurpleLight
import com.compose.showcase.ui.theme.ShowcaseTheme
import com.compose.showcase.ui.theme.TealDark

@Composable
internal fun IsoButton(
    modifier: Modifier = Modifier,
    depth: Dp = 8.dp,
    depthColor: Color = TealDark,
    borderColor: Color = PurpleDark,
    borderWidth: Dp = 2.dp,
    containerColor: Color = PurpleLight,
    content: @Composable () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val depthPx = with(LocalDensity.current) { depth.toPx() }
    val animatedDepthPx by animateFloatAsState(
        targetValue = if (isPressed) depthPx else 0F,
        animationSpec = if (isPressed) {
            tween(50, easing = EaseOut)
        } else {
            tween(300, easing = EaseInOut)
        },
        label = "Press animation",
    )

    val stroke = with(LocalDensity.current) {
        Stroke(width = borderWidth.toPx(), join = StrokeJoin.Round)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .drawBehind {
                val front = Path().apply {
                    moveTo(-animatedDepthPx, animatedDepthPx)
                    lineTo(size.width - animatedDepthPx, animatedDepthPx)
                    lineTo(size.width - animatedDepthPx, size.height + animatedDepthPx)
                    lineTo(-animatedDepthPx, size.height + animatedDepthPx)
                    close()
                }

                val leftDrop = Path().apply {
                    moveTo(-animatedDepthPx, animatedDepthPx)
                    lineTo(-depthPx, depthPx)
                    lineTo(-depthPx, size.height + depthPx)
                    lineTo(-animatedDepthPx, size.height + animatedDepthPx)
                    close()
                }

                val bottomDrop = Path().apply {
                    moveTo(-animatedDepthPx, size.height + animatedDepthPx)
                    lineTo(-depthPx, size.height + depthPx)
                    lineTo(size.width - depthPx, size.height + depthPx)
                    lineTo(size.width - animatedDepthPx, size.height + animatedDepthPx)
                    close()
                }

                drawPath(path = front, color = containerColor, style = Fill)
                drawPath(path = front, color = borderColor, style = stroke)

                drawPath(path = leftDrop, color = depthColor, style = Fill)
                drawPath(path = leftDrop, color = borderColor, style = stroke)

                drawPath(path = bottomDrop, color = depthColor, style = Fill)
                drawPath(path = bottomDrop, color = borderColor, style = stroke)
            },
    ) {
        Box(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    })
                }
                .offset {
                    IntOffset(
                        x = -animatedDepthPx.toInt(),
                        y = animatedDepthPx.toInt(),
                    )
                },
        ) {
            content()
        }
    }
}

@Preview(showBackground = false)
@Composable
fun IsoButtonPreview() {
    ShowcaseTheme {
        IsoButton {
            Box(
                modifier = Modifier.size(64.dp),
            )
        }
    }
}
