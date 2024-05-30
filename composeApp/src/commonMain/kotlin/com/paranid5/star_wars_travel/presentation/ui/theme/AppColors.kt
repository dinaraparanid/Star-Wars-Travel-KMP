package com.paranid5.star_wars_travel.presentation.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.presentation.ui.Pink40
import com.paranid5.star_wars_travel.presentation.ui.Pink80
import com.paranid5.star_wars_travel.presentation.ui.Purple40
import com.paranid5.star_wars_travel.presentation.ui.Purple80
import com.paranid5.star_wars_travel.presentation.ui.PurpleGrey40
import com.paranid5.star_wars_travel.presentation.ui.PurpleGrey80
import com.paranid5.star_wars_travel.presentation.ui.TransparentUtilityDark
import com.paranid5.star_wars_travel.presentation.ui.TransparentUtilityLight

@Immutable
data class AppColors(val colorScheme: ColorScheme = DarkColorScheme) {
    companion object {
        private val DarkColorScheme = darkColorScheme(
            primary = Purple80,
            secondary = PurpleGrey80,
            tertiary = Pink80,
            background = Color.DarkGray,
            onBackground = Color.White,
            onSurface = TransparentUtilityDark
        )

        private val LightColorScheme = lightColorScheme(
            primary = Purple40,
            secondary = PurpleGrey40,
            tertiary = Pink40,
            background = Color.LightGray,
            onBackground = Color.Black,
            onSurface = TransparentUtilityLight
        )

        fun create(theme: Theme) = AppColors(
            when (theme) {
                Theme.LIGHT -> LightColorScheme
                Theme.DARK -> DarkColorScheme
            }
        )
    }

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

internal val LocalColors = staticCompositionLocalOf { AppColors.create(Theme.DARK) }