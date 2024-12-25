package com.compose.showcase.core.decks.data.remote

import com.compose.showcase.R
import com.compose.showcase.core.decks.model.Deck
import com.compose.showcase.ui.theme.BlueDark
import com.compose.showcase.ui.theme.BlueLight
import com.compose.showcase.ui.theme.Pink
import com.compose.showcase.ui.theme.Salmon
import com.compose.showcase.ui.theme.SunriseRed
import com.compose.showcase.ui.theme.TealLight
import java.util.UUID

internal class StubDecksRemoteDataSource : DecksRemoteDataSource {
    override fun fetchDecks(): List<Deck> {
        return listOf(
            Deck(
                id = UUID.randomUUID(),
                order = 1,
                title = "Kanji deck",
                note = null,
                accentIcon = null,
                accentColorPrimary = BlueLight,
                accentColorSecondary = BlueDark,
                reviewsCount = 23,
                overdueCardsCount = 0,
                newCardsCount = 8,
            ),
            Deck(
                id = UUID.randomUUID(),
                order = 2,
                title = "Japanese Native Flower Species",
                note = null,
                accentIcon = R.drawable.image_flowers,
                accentColorPrimary = Pink,
                accentColorSecondary = SunriseRed,
                reviewsCount = 6,
                overdueCardsCount = 0,
                newCardsCount = 5,
            ),
            Deck(
                id = UUID.randomUUID(),
                order = 3,
                title = "Sushi types",
                note = null,
                accentIcon = R.drawable.image_sushi,
                accentColorPrimary = Salmon,
                accentColorSecondary = SunriseRed,
                reviewsCount = 6,
                overdueCardsCount = 2,
                newCardsCount = 0,
            ),
            Deck(
                id = UUID.randomUUID(),
                order = 4,
                title = "Japanese geography",
                note = "Make 5 new cards",
                accentIcon = R.drawable.image_map,
                accentColorPrimary = TealLight,
                accentColorSecondary = BlueLight,
                reviewsCount = 6,
                overdueCardsCount = 0,
                newCardsCount = 0,
            ),
        )
    }
}
