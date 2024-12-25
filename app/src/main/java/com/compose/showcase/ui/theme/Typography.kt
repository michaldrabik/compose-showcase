package com.compose.showcase.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.compose.showcase.R

private val InterFamily = FontFamily(
    Font(R.font.inter_medium, FontWeight.W500),
    Font(R.font.inter_bold, FontWeight.W700),
    Font(R.font.inter_black, FontWeight.W900),
)

private val GtMaruFamily = FontFamily(
    Font(R.font.gt_maru_black, FontWeight.W900),
)

val Typography = ShowcaseTypography(
    listHeader = TextStyle(
        fontFamily = GtMaruFamily,
        fontWeight = FontWeight.W900,
        fontSize = 20.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.6).sp,
        textAlign = TextAlign.Center,
    ),
    languageButtonCount = TextStyle(
        fontFamily = GtMaruFamily,
        fontWeight = FontWeight.W900,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.4).sp,
        textAlign = TextAlign.Center,
    ),
    languageButtonLabel = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
    ),
    // Profile
    profileButtonLabel = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    ),
    profileLanguageLabel = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
    ),
    // Decks
    deckItemTitle = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    deckItemNote = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    deckItemBadge = TextStyle(
        fontFamily = InterFamily,
        fontWeight = FontWeight.W700,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.35.sp,
        textAlign = TextAlign.Center,
    ),
    deckItemAccent = TextStyle(
        fontFamily = GtMaruFamily,
        fontWeight = FontWeight.W900,
        fontSize = 40.sp,
        lineHeight = 48.34.sp,
        letterSpacing = (-1.2).sp,
        textAlign = TextAlign.Center,
    ),
    allDecksTitle = TextStyle(
        fontFamily = GtMaruFamily,
        fontWeight = FontWeight.W900,
        fontSize = 36.sp,
        lineHeight = 42.sp,
        letterSpacing = (-1.08).sp,
        textAlign = TextAlign.Center,
    ),
)

@Immutable
data class ShowcaseTypography(
    val listHeader: TextStyle = TextStyle.Default,
    val languageButtonCount: TextStyle = TextStyle.Default,
    val languageButtonLabel: TextStyle = TextStyle.Default,
    // Profile
    val profileButtonLabel: TextStyle = TextStyle.Default,
    val profileLanguageLabel: TextStyle = TextStyle.Default,
    // Decks
    val deckItemTitle: TextStyle = TextStyle.Default,
    val deckItemNote: TextStyle = TextStyle.Default,
    val deckItemBadge: TextStyle = TextStyle.Default,
    val deckItemAccent: TextStyle = TextStyle.Default,
    val allDecksTitle: TextStyle = TextStyle.Default,
)
