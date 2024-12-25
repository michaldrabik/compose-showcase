package com.compose.showcase.core.profile

import androidx.compose.runtime.Immutable
import com.compose.showcase.core.language.model.Language

@Immutable
internal data class ProfileState(
    val language: Language? = null,
)
