package com.compose.showcase.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun BadgeChip(
    text: String,
    textColor: Color,
    containerColor: Color,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        color = textColor,
        style = ShowcaseTheme.typography.deckItemBadge,
        maxLines = 1,
        modifier = modifier
            .height(ShowcaseTheme.size.badgeHeight)
            .clip(RoundedCornerShape(ShowcaseTheme.size.badgeCorner))
            .background(containerColor)
            .wrapContentHeight(align = CenterVertically)
            .padding(horizontal = 8.dp),
    )
}

@Preview
@Composable
private fun BadgeChipPreview() {
    ShowcaseTheme {
        BadgeChip(
            text = "23 reviews",
            textColor = ShowcaseTheme.colors.textOnColor,
            containerColor = ShowcaseTheme.colors.deckBadgeReviewsBackground,
        )
    }
}
