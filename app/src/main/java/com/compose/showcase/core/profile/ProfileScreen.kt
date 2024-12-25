package com.compose.showcase.core.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.showcase.R
import com.compose.showcase.core.language.model.Language
import com.compose.showcase.core.profile.enums.ProfileOption
import com.compose.showcase.core.profile.enums.ProfileOption.STUDY
import com.compose.showcase.core.profile.views.ProfileButton
import com.compose.showcase.core.profile.views.ProfileLanguage
import com.compose.showcase.ui.extensions.noopClickable
import com.compose.showcase.ui.extensions.shadowMedium
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel,
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProfileScreenContent(
        language = state.language,
        modifier = modifier,
    )
}

@Composable
private fun ProfileScreenContent(
    language: Language?,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = spacedBy(ShowcaseTheme.spacing.profileListDivider),
        modifier = modifier
            .shadowMedium(
                shape = RoundedCornerShape(ShowcaseTheme.size.profileCorner),
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(ShowcaseTheme.size.profileCorner))
            .background(brush = Brush.verticalGradient(ShowcaseTheme.colors.profileBackground))
            .noopClickable()
            .padding(
                horizontal = ShowcaseTheme.spacing.profileHorizontal,
                vertical = ShowcaseTheme.spacing.profileVertical,
            ),
    ) {
        if (language != null) {
            ProfileLanguage(
                languageFlag = language.flag,
                languageCount = language.wordsCount,
            )
        }
        ProfileOption.entries.forEach {
            ProfileButton(
                label = stringResource(it.label),
                icon = it.icon,
                isSelected = (it == STUDY),
            )
        }
    }
}

@Preview(widthDp = 320)
@Composable
private fun ProfileMenuPreview() {
    ShowcaseTheme {
        ProfileScreenContent(
            language = Language(
                id = "zh",
                flag = R.drawable.ic_flag_china,
                wordsCount = 9999,
            ),
        )
    }
}
