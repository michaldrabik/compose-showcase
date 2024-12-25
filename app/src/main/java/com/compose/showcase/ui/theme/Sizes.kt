package com.compose.showcase.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Size = ShowcaseSize(
    topMenuButton = 40.dp,
    topMenuButtonIcon = 24.dp,
    languageButtonIcon = 16.dp,
    bottomMenuCorner = 128.dp,
    bottomMenuIcon = 24.dp,
    // Profile
    profileCorner = 44.dp,
    profileButtonCorner = 64.dp,
    profileButtonHeight = 64.dp,
    profileButtonIcon = 24.dp,
    // Profile language indicator
    profileLanguageCorner = 32.dp,
    profileLanguageHeight = 160.dp,
    profileLanguageIcon = 64.dp,
    profileLanguageIconBorder = 8.dp,
    profileLanguageLabelHeight = 24.dp,
    profileLanguageLabelCorner = 24.dp,
    // Decks
    deckCorner = 16.dp,
    deckListBackgroundHeight = 226.dp,
    deckListHeaderHeight = 32.dp,
    allDecksWidth = 240.dp,
    allDecksButton = 56.dp,
    allDecksButtonIcon = 28.dp,
    // Badges
    badgeCorner = 24.dp,
    badgeHeight = 24.dp,
)

@Immutable
data class ShowcaseSize(
    val topMenuButton: Dp = Dp.Unspecified,
    val topMenuButtonIcon: Dp = Dp.Unspecified,
    val languageButtonIcon: Dp = Dp.Unspecified,
    val bottomMenuCorner: Dp = Dp.Unspecified,
    val bottomMenuIcon: Dp = Dp.Unspecified,
    // Profile
    val profileCorner: Dp = Dp.Unspecified,
    val profileButtonCorner: Dp = Dp.Unspecified,
    val profileButtonHeight: Dp = Dp.Unspecified,
    val profileButtonIcon: Dp = Dp.Unspecified,
    // Profile language indicator
    val profileLanguageCorner: Dp = Dp.Unspecified,
    val profileLanguageHeight: Dp = Dp.Unspecified,
    val profileLanguageIcon: Dp = Dp.Unspecified,
    val profileLanguageIconBorder: Dp = Dp.Unspecified,
    val profileLanguageLabelHeight: Dp = Dp.Unspecified,
    val profileLanguageLabelCorner: Dp = Dp.Unspecified,
    // Decks
    val deckCorner: Dp = Dp.Unspecified,
    val deckListHeaderHeight: Dp = Dp.Unspecified,
    val deckListBackgroundHeight: Dp = Dp.Unspecified,
    val allDecksWidth: Dp = Dp.Unspecified,
    val allDecksButton: Dp = Dp.Unspecified,
    val allDecksButtonIcon: Dp = Dp.Unspecified,
    // Badges
    val badgeHeight: Dp = Dp.Unspecified,
    val badgeCorner: Dp = Dp.Unspecified,
)
