package com.compose.showcase.core.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.showcase.R
import com.compose.showcase.core.decks.data.remote.StubDecksRemoteDataSource
import com.compose.showcase.core.decks.views.DeckItemView
import com.compose.showcase.core.home.views.BottomMenu
import com.compose.showcase.core.home.views.LanguageButton
import com.compose.showcase.core.home.views.MenuButton
import com.compose.showcase.core.home.views.SettingsButton
import com.compose.showcase.core.language.data.StubLanguageDataSource
import com.compose.showcase.core.language.model.Language
import com.compose.showcase.ui.composables.BadgeChip
import com.compose.showcase.ui.composables.IsoButton
import com.compose.showcase.ui.composables.IsoCircleButton
import com.compose.showcase.ui.extensions.noIndicationClickable
import com.compose.showcase.ui.theme.ShowcaseTheme

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel,
    onProfileClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreenContent(
        state = state,
        onProfileClick = onProfileClick,
    )
}

@Composable
private fun HomeScreenContent(
    state: HomeState,
    onProfileClick: () -> Unit,
) {
    Scaffold(
        containerColor = ShowcaseTheme.colors.backgroundPrimary,
    ) { insets ->
        val scrollState = rememberScrollState()
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.image_yellow_sunrise),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(ShowcaseTheme.size.deckListBackgroundHeight)
                    .offset {
                        IntOffset(x = 0, y = -scrollState.value)
                    },
            )

            DecksList(
                state = state,
                scrollState = scrollState,
                insets = insets,
                onProfileClick = onProfileClick,
            )

            BottomMenu(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = insets.calculateBottomPadding() + ShowcaseTheme.spacing.screenBottom),
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DecksList(
    state: HomeState,
    scrollState: ScrollState,
    insets: PaddingValues,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // For the sake of testing, we're using a Column instead of a Lazy counterpart.
    // In a real-world scenario, we can use LazyColumn if the amount of decks can reach higher amounts.
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = spacedBy(ShowcaseTheme.spacing.deckListDivider),
            modifier = modifier
                .verticalScroll(scrollState)
                .padding(
                    bottom = insets.calculateBottomPadding() + ShowcaseTheme.spacing.deckListVertical,
                    start = ShowcaseTheme.spacing.screenHorizontal,
                    end = ShowcaseTheme.spacing.screenHorizontal,
                ),
        ) {
            TopMenu(
                language = state.language,
                onProfileClick = onProfileClick,
                modifier = Modifier
                    .padding(top = ShowcaseTheme.spacing.screenTop),
            )

            Box {
                AllDecksButton(state = state.allDecks)
                AllDecksGoButton()
            }

            Text(
                text = stringResource(R.string.title_today),
                color = ShowcaseTheme.colors.deckHeaderText,
                style = ShowcaseTheme.typography.listHeader,
                modifier = modifier
                    .height(ShowcaseTheme.size.deckListHeaderHeight)
                    .wrapContentSize(),
            )

            state.decks.forEach {
                DeckItemView(deck = it)
            }
        }
    }
}

@Composable
private fun TopMenu(
    language: Language?,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        MenuButton(
            modifier = Modifier
                .noIndicationClickable {
                    onProfileClick()
                },
        )
        if (language != null) {
            LanguageButton(
                languageFlag = language.flag,
                languageCount = language.wordsCount,
            )
        }
        SettingsButton()
    }
}

@Composable
private fun AllDecksButton(
    state: HomeState.AllDecks,
    modifier: Modifier = Modifier,
) {
    IsoButton(
        depthColor = ShowcaseTheme.colors.allDecksDepthColor,
        borderColor = ShowcaseTheme.colors.allDecksBorderColor,
        containerColor = ShowcaseTheme.colors.allDecksColor,
        modifier = modifier
            .padding(vertical = ShowcaseTheme.spacing.deckListDivider),
    ) {
        Column(
            verticalArrangement = spacedBy(
                space = ShowcaseTheme.spacing.allDecksDivider,
                alignment = CenterVertically,
            ),
            modifier = Modifier
                .width(ShowcaseTheme.size.allDecksWidth)
                .padding(
                    top = ShowcaseTheme.spacing.allDecksTop,
                    bottom = ShowcaseTheme.spacing.allDecksBottom,
                ),
        ) {
            Text(
                text = stringResource(R.string.title_all_decks),
                color = ShowcaseTheme.colors.allDecksTextColor,
                style = ShowcaseTheme.typography.allDecksTitle,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
            )
            Row(
                horizontalArrangement = spacedBy(8.dp, alignment = CenterHorizontally),
                modifier = Modifier.fillMaxWidth(),
            ) {
                BadgeChip(
                    text = pluralStringResource(
                        R.plurals.deck_reviews_count,
                        state.reviews,
                        state.reviews,
                    ),
                    textColor = ShowcaseTheme.colors.textOnColor,
                    containerColor = ShowcaseTheme.colors.deckBadgeReviewsBackground,
                )
                BadgeChip(
                    text = stringResource(R.string.deck_new_count, state.new),
                    textColor = ShowcaseTheme.colors.textOnColor,
                    containerColor = ShowcaseTheme.colors.deckBadgeNewBackground,
                )
            }
        }
    }
}

@Composable
fun BoxScope.AllDecksGoButton() {
    IsoCircleButton(
        containerSize = ShowcaseTheme.size.allDecksButton,
        containerColors = ShowcaseTheme.colors.allDecksButtonBackground,
        modifier = Modifier
            .align(Alignment.CenterEnd)
            .offset(
                x = (ShowcaseTheme.size.allDecksButton / 2) + 8.dp,
            ),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
                .width(ShowcaseTheme.size.allDecksButtonIcon),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val language = StubLanguageDataSource().getCurrentLanguage()
    val decks = StubDecksRemoteDataSource().fetchDecks()
    ShowcaseTheme {
        HomeScreenContent(
            state = HomeState(
                decks = decks,
                allDecks = HomeState.AllDecks(
                    reviews = 134,
                    new = 18,
                ),
                language = language,
            ),
            onProfileClick = {},
        )
    }
}
