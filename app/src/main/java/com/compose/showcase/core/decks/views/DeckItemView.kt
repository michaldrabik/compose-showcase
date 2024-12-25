package com.compose.showcase.core.decks.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.compose.showcase.R
import com.compose.showcase.core.decks.model.Deck
import com.compose.showcase.ui.composables.BadgeChip
import com.compose.showcase.ui.extensions.shadowMedium
import com.compose.showcase.ui.theme.BlueDark
import com.compose.showcase.ui.theme.BlueLight
import com.compose.showcase.ui.theme.ShowcaseTheme
import java.util.UUID

@Composable
internal fun DeckItemView(
    deck: Deck,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .shadowMedium(
                shape = RoundedCornerShape(ShowcaseTheme.size.deckCorner),
                color = ShowcaseTheme.colors.shadowPrimary,
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(ShowcaseTheme.size.deckCorner))
            .background(ShowcaseTheme.colors.deckBackground)
            .padding(16.dp),
    ) {
        Row(horizontalArrangement = spacedBy(16.dp)) {
            DeckItemImage(deck = deck)

            Column(
                verticalArrangement = spacedBy(8.dp, CenterVertically),
                modifier = Modifier.align(CenterVertically),
            ) {
                Text(
                    text = deck.title,
                    color = ShowcaseTheme.colors.textPrimary,
                    style = ShowcaseTheme.typography.deckItemTitle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                DeckItemBadges(deck = deck)

                if (!deck.note.isNullOrBlank()) {
                    Text(
                        text = deck.note,
                        color = ShowcaseTheme.colors.deckNoteText,
                        style = ShowcaseTheme.typography.deckItemNote,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Composable
private fun DeckItemImage(
    deck: Deck,
    modifier: Modifier = Modifier,
) {
    if (deck.accentIcon == null) {
        Text(
            text = deck.title.first().uppercase(),
            style = ShowcaseTheme.typography.deckItemAccent,
            color = deck.accentColorSecondary,
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(deck.accentColorPrimary)
                .wrapContentSize()
                .padding(bottom = 1.dp),
        )
    } else {
        Image(
            painter = painterResource(deck.accentIcon),
            contentDescription = null,
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(deck.accentColorPrimary)
                .wrapContentSize()
                .size(40.dp),
        )
    }
}

@Composable
private fun DeckItemBadges(
    deck: Deck,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = spacedBy(8.dp),
        modifier = modifier,
    ) {
        BadgeChip(
            text = pluralStringResource(
                R.plurals.deck_reviews_count,
                deck.reviewsCount,
                deck.reviewsCount,
            ),
            textColor = ShowcaseTheme.colors.textOnColor,
            containerColor = ShowcaseTheme.colors.deckBadgeReviewsBackground,
        )

        if (deck.overdueCardsCount > 0) {
            BadgeChip(
                text = stringResource(R.string.deck_overdue_count, deck.overdueCardsCount),
                textColor = ShowcaseTheme.colors.textOnColor,
                containerColor = ShowcaseTheme.colors.deckBadgeOverdueBackground,
            )
        } else {
            BadgeChip(
                text = stringResource(R.string.deck_new_count, deck.newCardsCount),
                textColor = ShowcaseTheme.colors.textOnColor,
                containerColor = ShowcaseTheme.colors.deckBadgeNewBackground,
            )
        }
    }
}

@Preview(widthDp = 340)
@Composable
private fun DeckItemViewPreview(
    @PreviewParameter(LoremIpsum::class) lorem: String,
) {
    ShowcaseTheme {
        val deck = Deck(
            id = UUID.randomUUID(),
            order = 1,
            title = lorem.take(18),
            note = null,
            accentIcon = R.drawable.image_sushi,
            accentColorPrimary = BlueLight,
            accentColorSecondary = BlueDark,
            reviewsCount = 42,
            overdueCardsCount = 0,
            newCardsCount = 5,
        )
        Column(verticalArrangement = spacedBy(16.dp)) {
            DeckItemView(deck = deck)
            DeckItemView(
                deck = deck.copy(
                    title = "Kanji decks",
                    accentIcon = null,
                    overdueCardsCount = 3,
                ),
            )
            DeckItemView(deck = deck.copy(note = "Make 5 new cards"))
        }
    }
}
