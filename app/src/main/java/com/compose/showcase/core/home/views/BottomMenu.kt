package com.compose.showcase.core.home.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.showcase.R
import com.compose.showcase.ui.composables.GradientIcon
import com.compose.showcase.ui.extensions.shadowLarge
import com.compose.showcase.ui.theme.LocalShowcaseColors
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun BottomMenu(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = CenterVertically,
        horizontalArrangement = spacedBy(ShowcaseTheme.spacing.bottomMenuDivider),
        modifier = modifier
            .shadowLarge(
                shape = RoundedCornerShape(ShowcaseTheme.size.bottomMenuCorner),
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .clip(RoundedCornerShape(ShowcaseTheme.size.bottomMenuCorner))
            .background(ShowcaseTheme.colors.bottomMenuBorder)
            .padding(1.dp)
            .clip(RoundedCornerShape(ShowcaseTheme.size.bottomMenuCorner))
            .background(ShowcaseTheme.colors.bottomMenuBackground)
            .padding(
                vertical = 16.dp,
                horizontal = 24.dp,
            ),
    ) {
        BottomMenuItem(
            iconRes = R.drawable.ic_book,
            isSelected = true,
        )
        BottomMenuItem(
            iconRes = R.drawable.ic_books,
            isSelected = false,
        )
    }
}

@Composable
private fun BottomMenuItem(
    @DrawableRes iconRes: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val iconOnColors = LocalShowcaseColors.current.bottomMenuIconOn
    val iconOffColor = LocalShowcaseColors.current.bottomMenuIconOff

    if (isSelected) {
        GradientIcon(
            painter = painterResource(iconRes),
            gradientColors = iconOnColors,
            modifier = modifier.size(ShowcaseTheme.size.bottomMenuIcon),
        )
    } else {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = iconOffColor,
            modifier = modifier.size(ShowcaseTheme.size.bottomMenuIcon),
        )
    }
}

@Preview
@Composable
private fun BottomMenuPreview() {
    ShowcaseTheme {
        BottomMenu()
    }
}
