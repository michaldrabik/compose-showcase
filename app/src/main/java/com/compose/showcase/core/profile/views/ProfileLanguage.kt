package com.compose.showcase.core.profile.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.showcase.R
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun ProfileLanguage(
    languageFlag: Int,
    languageCount: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, CenterVertically),
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .height(ShowcaseTheme.size.profileLanguageHeight)
            .clip(RoundedCornerShape(ShowcaseTheme.size.profileLanguageCorner))
            .background(ShowcaseTheme.colors.profileButtonBackgroundOff),
    ) {
        Image(
            painter = painterResource(languageFlag),
            contentDescription = null,
            modifier = modifier
                .clip(CircleShape)
                .background(ShowcaseTheme.colors.profileLanguageBorder)
                .padding(ShowcaseTheme.size.profileLanguageIconBorder)
                .size(ShowcaseTheme.size.profileLanguageIcon),
        )
        Text(
            text = pluralStringResource(
                R.plurals.profile_language_words,
                languageCount,
                languageCount,
            ),
            color = ShowcaseTheme.colors.profileLanguageText,
            style = ShowcaseTheme.typography.profileLanguageLabel,
            maxLines = 1,
            modifier = modifier
                .height(ShowcaseTheme.size.profileLanguageLabelHeight)
                .clip(RoundedCornerShape(ShowcaseTheme.size.profileLanguageLabelCorner))
                .background(ShowcaseTheme.colors.profileLanguageBorder)
                .wrapContentHeight(align = CenterVertically)
                .padding(horizontal = 8.dp),
        )
    }
}

@Preview(
    widthDp = 340,
    backgroundColor = 0xFFFE4670,
    showBackground = true,
)
@Composable
private fun ProfileLanguagePreview() {
    ShowcaseTheme {
        ProfileLanguage(
            languageFlag = R.drawable.ic_flag_china,
            languageCount = 5348,
        )
    }
}
