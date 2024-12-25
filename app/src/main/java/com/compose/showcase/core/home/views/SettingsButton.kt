package com.compose.showcase.core.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.compose.showcase.R
import com.compose.showcase.ui.extensions.shadowMedium
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun SettingsButton(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(R.drawable.ic_gear),
        contentDescription = null,
        tint = ShowcaseTheme.colors.topMenuButtonIcon,
        modifier = modifier
            .shadowMedium(
                shape = CircleShape,
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .size(ShowcaseTheme.size.topMenuButton)
            .clip(CircleShape)
            .background(ShowcaseTheme.colors.topMenuButtonBackground)
            .wrapContentSize()
            .size(ShowcaseTheme.size.topMenuButtonIcon),
    )
}

@Preview
@Composable
private fun SettingsButtonPreview() {
    ShowcaseTheme {
        SettingsButton()
    }
}
