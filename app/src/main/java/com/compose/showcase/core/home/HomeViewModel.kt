package com.compose.showcase.core.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.showcase.core.home.usecases.GetDecksUseCase
import com.compose.showcase.core.language.usecases.GetLanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getLanguageUseCase: GetLanguageUseCase,
    private val getDecksUseCase: GetDecksUseCase,
) : ViewModel() {
    private val initialState = HomeState()

    private val decksState = MutableStateFlow(initialState.decks)
    private val allDecksState = MutableStateFlow(initialState.allDecks)
    private val languageState = MutableStateFlow(initialState.language)

    init {
        loadLanguage()
        loadDecks()
    }

    private fun loadLanguage() {
        viewModelScope.launch {
            val language = getLanguageUseCase.getLanguage()
            languageState.update { language }
        }
    }

    private fun loadDecks() {
        viewModelScope.launch {
            val decks = getDecksUseCase.getDecks()
            allDecksState.update {
                // In the real app this would probably be calculated from decks.
                // In our case we'll just hardcode it.
                HomeState.AllDecks(
                    reviews = 134,
                    new = 18,
                )
            }
            decksState.update { decks }
        }
    }

    val state: StateFlow<HomeState> = combine(
        decksState,
        allDecksState,
        languageState,
    ) { s1, s2, s3 ->
        HomeState(
            decks = s1,
            allDecks = s2,
            language = s3,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = initialState,
    )
}
