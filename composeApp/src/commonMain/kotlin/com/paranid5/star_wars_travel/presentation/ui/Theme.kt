package com.paranid5.star_wars_travel.presentation.ui

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color.DarkGray,
    onBackground = Color.White,
    onSurface = TransparentUtilityDark
)

val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.LightGray,
    onBackground = Color.Black,
    onSurface = TransparentUtilityLight
)

class AppColors(private val colorScheme: ColorScheme = DarkColorScheme) {
    val primary
        get() = colorScheme.primary

    val secondary
        get() = colorScheme.secondary

    val background
        get() = colorScheme.background

    val onBackground
        get() = colorScheme.onBackground

    val transparentUtility
        get() = colorScheme.onSurface
}

val LocalAppColors = staticCompositionLocalOf { AppColors() }