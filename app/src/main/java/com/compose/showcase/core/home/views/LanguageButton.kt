package com.compose.showcase.core.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.showcase.R
import com.compose.showcase.ui.extensions.shadowSmall
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun LanguageButton(
    languageFlag: Int,
    languageCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = spacedBy(ShowcaseTheme.spacing.languageButtonDivider),
        modifier = modifier
            .shadowSmall(
                shape = RoundedCornerShape(percent = 100),
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .clip(RoundedCornerShape(percent = 100))
            .background(Brush.verticalGradient(ShowcaseTheme.colors.languageButtonBackground))
            .height(ShowcaseTheme.size.topMenuButton)
            .padding(start = 12.dp, end = 16.dp),
    ) {
        Image(
            painter = painterResource(languageFlag),
            contentDescription = null,
            modifier = modifier.size(ShowcaseTheme.size.languageButtonIcon),
        )
        Text(
            text = "$languageCount",
            color = ShowcaseTheme.colors.textOnColor,
            style = ShowcaseTheme.typography.languageButtonCount,
            modifier = Modifier.padding(bottom = 1.dp),
        )
        Text(
            text = pluralStringResource(
                R.plurals.language_words,
                languageCount,
            ),
            color = ShowcaseTheme.colors.textOnColor,
            style = ShowcaseTheme.typography.languageButtonLabel,
            modifier = Modifier.padding(bottom = 1.dp),
        )
    }
}

@Preview
@Composable
private fun LanguageButtonPreview() {
    ShowcaseTheme {
        LanguageButton(
            languageFlag = R.drawable.ic_flag_china,
            languageCount = 5483,
        )
    }
}
