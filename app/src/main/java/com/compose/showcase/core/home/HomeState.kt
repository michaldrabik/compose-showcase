package com.compose.showcase.core.home

import androidx.compose.runtime.Immutable
import com.compose.showcase.core.decks.model.Deck
import com.compose.showcase.core.language.model.Language

@Immutable
internal data class HomeState(
    val language: Language? = null,
    val decks: List<Deck> = emptyList(),
    val allDecks: AllDecks = AllDecks(),
) {
    data class AllDecks(
        val reviews: Int = 0,
        val new: Int = 0,
    )
}
