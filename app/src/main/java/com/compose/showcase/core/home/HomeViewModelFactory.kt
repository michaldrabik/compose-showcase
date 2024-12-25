package com.compose.showcase.core.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.compose.showcase.core.decks.data.remote.StubDecksRemoteDataSource
import com.compose.showcase.core.home.usecases.GetDecksUseCase
import com.compose.showcase.core.language.data.StubLanguageDataSource
import com.compose.showcase.core.language.usecases.GetLanguageUseCase

internal object HomeViewModelFactory {
    fun get(): ViewModelProvider.Factory {
        return viewModelFactory {
            initializer {
                HomeViewModel(
                    getLanguageUseCase = GetLanguageUseCase(
                        languageRemoteSource = StubLanguageDataSource(),
                    ),
                    getDecksUseCase = GetDecksUseCase(
                        decksRemoteSource = StubDecksRemoteDataSource(),
                    ),
                )
            }
        }
    }
}
