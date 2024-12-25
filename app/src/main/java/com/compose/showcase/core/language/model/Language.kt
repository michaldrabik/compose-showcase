package com.compose.showcase.core.language.model

import androidx.annotation.DrawableRes

data class Language(
    val id: String,
    // In real app, this could be a URL to the image
    @DrawableRes val flag: Int,
    val wordsCount: Int,
)
