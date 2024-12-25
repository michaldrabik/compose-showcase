package com.compose.showcase.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalShowcaseColors = staticCompositionLocalOf { ShowcaseColors() }
val LocalShowcaseTypography = staticCompositionLocalOf { ShowcaseTypography() }
val LocalShowcaseSpacing = staticCompositionLocalOf { ShowcaseSpacing() }
val LocaleShowcaseSize = staticCompositionLocalOf { ShowcaseSize() }

object ShowcaseTheme {
    val colors: ShowcaseColors
        @Composable
        get() = LocalShowcaseColors.current

    val typography: ShowcaseTypography
        @Composable
        get() = LocalShowcaseTypography.current

    val spacing: ShowcaseSpacing
        @Composable
        get() = LocalShowcaseSpacing.current

    val size: ShowcaseSize
        @Composable
        get() = LocaleShowcaseSize.current
}

@Composable
fun ShowcaseTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalShowcaseColors provides LightColors,
        LocalShowcaseSpacing provides Spacing,
        LocaleShowcaseSize provides Size,
        LocalShowcaseTypography provides Typography,
        content = content,
    )
}
