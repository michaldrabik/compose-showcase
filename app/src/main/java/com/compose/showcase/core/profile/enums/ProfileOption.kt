package com.compose.showcase.core.profile.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.compose.showcase.R

internal enum class ProfileOption(
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
) {
    STUDY(R.string.profile_study, R.drawable.ic_book),
    DICTIONARY(R.string.profile_dictionary, R.drawable.ic_books),
    FEEDBACK(R.string.profile_feedback, R.drawable.ic_smiley),
    SETTINGS(R.string.profile_settings, R.drawable.ic_gear),
}
