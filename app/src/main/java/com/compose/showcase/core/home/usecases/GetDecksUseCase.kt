package com.compose.showcase.core.home.usecases

import com.compose.showcase.core.decks.data.remote.DecksRemoteDataSource
import com.compose.showcase.core.decks.model.Deck

internal class GetDecksUseCase(
    private val decksRemoteSource: DecksRemoteDataSource,
) {
    fun getDecks(): List<Deck> {
        return decksRemoteSource.fetchDecks()
    }
}
