package com.compose.showcase.core.profile

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.compose.showcase.core.language.data.StubLanguageDataSource
import com.compose.showcase.core.language.usecases.GetLanguageUseCase

internal object ProfileViewModelFactory {
    fun get(): ViewModelProvider.Factory {
        return viewModelFactory {
            initializer {
                ProfileViewModel(
                    getLanguageUseCase = GetLanguageUseCase(
                        languageRemoteSource = StubLanguageDataSource(),
                    ),
                )
            }
        }
    }
}
