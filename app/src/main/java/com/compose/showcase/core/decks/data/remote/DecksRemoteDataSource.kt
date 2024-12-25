package com.compose.showcase.core.decks.data.remote

import com.compose.showcase.core.decks.model.Deck

interface DecksRemoteDataSource {
    fun fetchDecks(): List<Deck>
}
