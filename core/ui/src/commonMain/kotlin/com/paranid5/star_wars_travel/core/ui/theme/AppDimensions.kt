package com.paranid5.star_wars_travel.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimensions(val padding: Padding, val corners: Corners) {
    companion object {
        val default get() = AppDimensions(
            padding = Padding(
                zero = 0.dp,
                minimum = 2.dp,
                extraSmall = 4.dp,
                small = 8.dp,
                medium = 12.dp,
                extraMedium = 16.dp,
                big = 20.dp,
                extraBig = 48.dp,
                large = 32.dp,
                extraLarge = 48.dp,
            ),
            corners = Corners(
                medium = 24.dp
            )
        )
    }

    @Immutable
    data class Padding(
        val zero: Dp,
        val minimum: Dp,
        val extraSmall: Dp,
        val small: Dp,
        val medium: Dp,
        val extraMedium: Dp,
        val large: Dp,
        val extraLarge: Dp,
        val big: Dp,
        val extraBig: Dp,
    )

    @Immutable
    data class Corners(val medium: Dp)
}

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions.default }