package com.compose.showcase.core.main

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.showcase.core.home.HomeScreen
import com.compose.showcase.core.home.HomeViewModelFactory
import com.compose.showcase.core.profile.ProfileScreen
import com.compose.showcase.core.profile.ProfileViewModelFactory
import com.compose.showcase.ui.extensions.noIndicationClickable
import com.compose.showcase.ui.theme.ShowcaseTheme

private val SlideEasing = CubicBezierEasing(0.7F, -0.4F, 0.4F, 1.4F)

@Composable
internal fun MainScreen() {
    var isProfileVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreen(
            viewModel = viewModel(factory = HomeViewModelFactory.get()),
            onProfileClick = { isProfileVisible = true },
        )

        AnimatedProfileMask(
            isVisible = isProfileVisible,
            onClick = { isProfileVisible = false },
        )

        AnimatedProfileScreen(
            isVisible = isProfileVisible,
        )
    }

    BackHandler(enabled = isProfileVisible) {
        isProfileVisible = false
    }
}

@Composable
private fun AnimatedProfileScreen(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
) {
    val offsetX = with(LocalDensity.current) {
        ShowcaseTheme.spacing.screenHorizontal.toPx().toInt()
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            animationSpec = tween(durationMillis = 300, easing = SlideEasing),
            initialOffsetX = { (-it) + offsetX },
        ),
        exit = slideOutHorizontally(
            animationSpec = tween(durationMillis = 300, easing = SlideEasing),
            targetOffsetX = { -it },
        ),
    ) {
        ProfileScreen(
            viewModel = viewModel(factory = ProfileViewModelFactory.get()),
            modifier = modifier
                .padding(
                    top = ShowcaseTheme.spacing.screenTop,
                    start = ShowcaseTheme.spacing.screenHorizontal,
                    end = ShowcaseTheme.spacing.screenHorizontal,
                ),
        )
    }
}

@Composable
private fun AnimatedProfileMask(
    isVisible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(tween(durationMillis = 300)),
        exit = fadeOut(tween(durationMillis = 300)),
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(ShowcaseTheme.colors.profileOverlay)
                .noIndicationClickable { onClick() },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    ShowcaseTheme {
        MainScreen()
    }
}
