package com.compose.showcase.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Spacing = ShowcaseSpacing(
    screenHorizontal = 16.dp,
    screenTop = 59.dp,
    screenBottom = 32.dp,
    bottomMenuDivider = 32.dp,
    languageButtonDivider = 8.dp,
    // Profile
    profileButtonDivider = 16.dp,
    profileHorizontal = 16.dp,
    profileVertical = 16.dp,
    profileListDivider = 16.dp,
    // Decks
    deckListDivider = 16.dp,
    deckListVertical = 126.dp,
    allDecksTop = 32.dp,
    allDecksBottom = 16.dp,
    allDecksDivider = 16.dp,
)

@Immutable
data class ShowcaseSpacing(
    val screenHorizontal: Dp = Dp.Unspecified,
    val screenTop: Dp = Dp.Unspecified,
    val screenBottom: Dp = Dp.Unspecified,
    val bottomMenuDivider: Dp = Dp.Unspecified,
    val languageButtonDivider: Dp = Dp.Unspecified,
    // Profile
    val profileHorizontal: Dp = Dp.Unspecified,
    val profileVertical: Dp = Dp.Unspecified,
    val profileListDivider: Dp = Dp.Unspecified,
    val profileButtonDivider: Dp = Dp.Unspecified,
    // Decks
    val deckListDivider: Dp = Dp.Unspecified,
    val deckListVertical: Dp = Dp.Unspecified,
    val allDecksTop: Dp = Dp.Unspecified,
    val allDecksBottom: Dp = Dp.Unspecified,
    val allDecksDivider: Dp = Dp.Unspecified,
)
