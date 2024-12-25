package com.compose.showcase.core.decks.model

import androidx.compose.ui.graphics.Color
import java.util.UUID

data class Deck(
    val id: UUID,
    val order: Int,
    val title: String,
    val note: String?,
    // In real app, this could be a URL to the image
    val accentIcon: Int?,
    val accentColorPrimary: Color,
    val accentColorSecondary: Color,
    val reviewsCount: Int,
    val overdueCardsCount: Int,
    val newCardsCount: Int,
) {
    init {
        require(accentIcon == null || accentIcon > 0) {
            "Valid icon resource must be provided!"
        }
        require(note == null || note.isNotBlank()) {
            "Non empty note must be provided!"
        }
    }
}
