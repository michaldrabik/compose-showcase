package com.compose.showcase.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Black = Color(0x00000000)

val PurpleLight = Color(0xFFEDE3FF)
val PurpleDark = Color(0xFF00005A)

val SunriseOrange = Color(0xFFFF9345)
val SunriseRed = Color(0xFFFE4670)

val Green = Color(0xFF00C7A4)
val Pink = Color(0xFFFFE0F5)
val TealLight = Color(0xFFDDFFF9)
val TealDark = Color(0xFFD4F2FF)
val Salmon = Color(0xFFFFDCC2)
val BlueLight = Color(0xFFDFF4FF)
val BlueDark = Color(0xFF3C91FF)

// We'll only support single colors scheme for this test app.
val LightColors = ShowcaseColors(
    backgroundPrimary = PurpleLight,
    shadowPrimary = PurpleDark.copy(alpha = 1F),
    textPrimary = PurpleDark,
    textOnColor = White,
    // Top menu
    topMenuButtonIcon = PurpleDark,
    topMenuButtonBackground = White,
    languageButtonBackground = listOf(SunriseOrange, SunriseRed),
    // Bottom menu
    bottomMenuBackground = White,
    bottomMenuBorder = Black.copy(alpha = 0.03F),
    bottomMenuIconOff = PurpleDark.copy(alpha = 0.25F),
    bottomMenuIconOn = listOf(SunriseOrange, SunriseRed),
    // Profile
    profileBackground = listOf(SunriseOrange, SunriseRed),
    profileOverlay = PurpleDark.copy(alpha = 0.75F),
    profileButtonTextOn = listOf(SunriseOrange, SunriseRed),
    profileButtonTextOff = White,
    profileButtonBackgroundOn = White,
    profileButtonBackgroundOff = White.copy(alpha = 0.15F),
    profileLanguageBackground = White.copy(alpha = 0.15F),
    profileLanguageBorder = White.copy(alpha = 0.2F),
    profileLanguageText = White,
    // Decks
    deckHeaderText = PurpleDark,
    deckNoteText = SunriseRed,
    deckBackground = White,
    deckBadgeNewBackground = BlueDark,
    deckBadgeOverdueBackground = SunriseRed,
    deckBadgeReviewsBackground = Green,
    allDecksColor = PurpleLight,
    allDecksTextColor = PurpleDark,
    allDecksBorderColor = PurpleDark,
    allDecksDepthColor = TealDark,
    allDecksButtonBackground = listOf(SunriseOrange, SunriseRed),
)

@Immutable
data class ShowcaseColors(
    val backgroundPrimary: Color = Color.Unspecified,
    val shadowPrimary: Color = Color.Unspecified,
    val textPrimary: Color = Color.Unspecified,
    val textOnColor: Color = Color.Unspecified,
    // Top menu
    val topMenuButtonBackground: Color = Color.Unspecified,
    val topMenuButtonIcon: Color = Color.Unspecified,
    val languageButtonBackground: List<Color> = emptyList(),
    // Bottom menu
    val bottomMenuBackground: Color = Color.Unspecified,
    val bottomMenuBorder: Color = Color.Unspecified,
    val bottomMenuIconOff: Color = Color.Unspecified,
    val bottomMenuIconOn: List<Color> = emptyList(),
    // Profile
    val profileBackground: List<Color> = emptyList(),
    val profileOverlay: Color = Color.Unspecified,
    val profileButtonBackgroundOn: Color = Color.Unspecified,
    val profileButtonBackgroundOff: Color = Color.Unspecified,
    val profileButtonTextOn: List<Color> = emptyList(),
    val profileButtonTextOff: Color = Color.Unspecified,
    val profileLanguageBackground: Color = Color.Unspecified,
    val profileLanguageBorder: Color = Color.Unspecified,
    val profileLanguageText: Color = Color.Unspecified,
    // Decks
    val deckHeaderText: Color = Color.Unspecified,
    val deckNoteText: Color = Color.Unspecified,
    val deckBackground: Color = Color.Unspecified,
    val deckBadgeReviewsBackground: Color = Color.Unspecified,
    val deckBadgeNewBackground: Color = Color.Unspecified,
    val deckBadgeOverdueBackground: Color = Color.Unspecified,
    val allDecksColor: Color = Color.Unspecified,
    val allDecksTextColor: Color = Color.Unspecified,
    val allDecksBorderColor: Color = Color.Unspecified,
    val allDecksDepthColor: Color = Color.Unspecified,
    val allDecksButtonBackground: List<Color> = emptyList(),
)
