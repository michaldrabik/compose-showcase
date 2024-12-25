package com.compose.showcase.ui.extensions

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.noIndicationClickable(onClick: () -> Unit): Modifier {
    return clickable(
        interactionSource = null,
        indication = null,
        onClick = onClick,
    )
}

fun Modifier.noopClickable(): Modifier {
    return clickable(
        interactionSource = null,
        indication = null,
    ) {
        // NOOP
    }
}
