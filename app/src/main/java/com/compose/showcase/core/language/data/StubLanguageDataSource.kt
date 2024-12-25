package com.compose.showcase.core.language.data

import com.compose.showcase.R
import com.compose.showcase.core.language.model.Language

internal class StubLanguageDataSource : LanguageDataSource {
    override fun getCurrentLanguage(): Language {
        return Language(
            id = "zh",
            flag = R.drawable.ic_flag_china,
            wordsCount = 5483,
        )
    }
}
