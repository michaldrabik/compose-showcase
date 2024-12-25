package com.compose.showcase.core.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.compose.showcase.R
import com.compose.showcase.ui.extensions.shadowMedium
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun MenuButton(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.image_migaku),
        contentDescription = null,
        modifier = modifier
            .shadowMedium(
                shape = CircleShape,
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .size(ShowcaseTheme.size.topMenuButton)
            .clip(CircleShape),
    )
}

@Preview
@Composable
private fun MenuButtonPreview() {
    ShowcaseTheme {
        MenuButton()
    }
}
