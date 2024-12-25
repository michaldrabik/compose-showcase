package com.compose.showcase.core.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.showcase.core.language.usecases.GetLanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ProfileViewModel(
    private val getLanguageUseCase: GetLanguageUseCase,
) : ViewModel() {
    private val initialState = ProfileState()
    private val languageState = MutableStateFlow(initialState.language)

    init {
        loadLanguage()
    }

    private fun loadLanguage() {
        viewModelScope.launch {
            val language = getLanguageUseCase.getLanguage()
            languageState.update { language }
        }
    }

    val state: StateFlow<ProfileState> = combine(
        languageState,
    ) { s1 ->
        ProfileState(
            language = s1[0],
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = initialState,
    )
}
