package com.compose.showcase.core.language.data

import com.compose.showcase.core.language.model.Language

interface LanguageDataSource {
    fun getCurrentLanguage(): Language
}
