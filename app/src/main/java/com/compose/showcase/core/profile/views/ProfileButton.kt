package com.compose.showcase.core.profile.views

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.showcase.R
import com.compose.showcase.ui.composables.GradientIcon
import com.compose.showcase.ui.theme.LocalShowcaseColors
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun ProfileButton(
    label: String,
    @DrawableRes icon: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val isPressedScale by animateFloatAsState(
        targetValue = if (isPressed) 0.97F else 1F,
        animationSpec = if (isPressed) {
            tween(durationMillis = 0)
        } else {
            spring(
                dampingRatio = 0.15F,
                stiffness = 600F,
            )
        },
        label = "Press animation",
    )

    val backgroundColor = if (isSelected) {
        ShowcaseTheme.colors.profileButtonBackgroundOn
    } else {
        ShowcaseTheme.colors.profileButtonBackgroundOff
    }

    Row(
        horizontalArrangement = spacedBy(ShowcaseTheme.spacing.profileButtonDivider),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer(
                scaleX = isPressedScale,
                scaleY = isPressedScale,
            )
            .height(ShowcaseTheme.size.profileButtonHeight)
            .clip(RoundedCornerShape(ShowcaseTheme.size.profileButtonCorner))
            .background(backgroundColor)
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(horizontal = 24.dp)
            .clickable(
                enabled = !isSelected,
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    // NOOP
                },
            ),
    ) {
        ProfileButtonContent(
            isSelected = isSelected,
            icon = icon,
            label = label,
        )
    }
}

@Composable
private fun ProfileButtonContent(
    label: String,
    icon: Int,
    isSelected: Boolean,
) {
    val textOnColors = LocalShowcaseColors.current.profileButtonTextOn
    val textStyle = if (isSelected) {
        ShowcaseTheme.typography.profileButtonLabel
            .copy(Brush.verticalGradient(textOnColors))
    } else {
        ShowcaseTheme.typography.profileButtonLabel
    }

    if (isSelected) {
        GradientIcon(
            painter = painterResource(icon),
            gradientColors = textOnColors,
            modifier = Modifier.size(ShowcaseTheme.size.bottomMenuIcon),
        )
    } else {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = ShowcaseTheme.colors.profileButtonTextOff,
            modifier = Modifier.size(ShowcaseTheme.size.profileButtonIcon),
        )
    }

    Text(
        text = label,
        color = ShowcaseTheme.colors.profileButtonTextOff,
        style = textStyle,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview(widthDp = 340)
@Composable
private fun ProfileButtonPreview() {
    ShowcaseTheme {
        Column(verticalArrangement = spacedBy(16.dp)) {
            ProfileButton(
                label = stringResource(R.string.profile_study),
                icon = R.drawable.ic_book,
                isSelected = true,
            )
            ProfileButton(
                label = stringResource(R.string.profile_settings),
                icon = R.drawable.ic_gear,
                isSelected = false,
            )
        }
    }
}
