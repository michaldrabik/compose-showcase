package com.compose.showcase.core.language.usecases

import com.compose.showcase.core.language.data.LanguageDataSource
import com.compose.showcase.core.language.model.Language

internal class GetLanguageUseCase(
    private val languageRemoteSource: LanguageDataSource,
) {
    fun getLanguage(): Language {
        return languageRemoteSource.getCurrentLanguage()
    }
}
