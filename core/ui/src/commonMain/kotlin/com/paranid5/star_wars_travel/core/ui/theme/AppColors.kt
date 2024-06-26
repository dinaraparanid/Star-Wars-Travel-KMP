package com.paranid5.star_wars_travel.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.materialkolor.ktx.darken
import com.materialkolor.ktx.lighten
import com.paranid5.star_wars_travel.core.ui.AppBarColor
import com.paranid5.star_wars_travel.core.ui.Pink40
import com.paranid5.star_wars_travel.core.ui.Pink80
import com.paranid5.star_wars_travel.core.ui.Purple40
import com.paranid5.star_wars_travel.core.ui.Purple80
import com.paranid5.star_wars_travel.core.ui.PurpleGrey40
import com.paranid5.star_wars_travel.core.ui.PurpleGrey80
import com.paranid5.star_wars_travel.core.ui.StarWarsHologram
import com.paranid5.star_wars_travel.core.ui.StarWarsYellow
import com.paranid5.star_wars_travel.core.ui.TransparentUtilityDark
import com.paranid5.star_wars_travel.core.ui.TransparentUtilityLight
import com.paranid5.star_wars_travel.domain.entities.Theme

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

    val backgroundGradient
        get() = Brush.linearGradient(
            listOf(
                colorScheme.background.lighten(ratio = 1.5F),
                colorScheme.background.darken(ratio = 1.5F),
            )
        )

    val onBackground
        get() = colorScheme.onBackground

    val transparentUtility
        get() = colorScheme.onSurface

    val appBarColor
        get() = AppBarColor

    val starWarsYellow
        get() = StarWarsYellow

    fun getTabColor(isScreenCurrent: Boolean) =
        if (isScreenCurrent) StarWarsHologram else StarWarsYellow
}

internal val LocalColors = staticCompositionLocalOf { AppColors.create(Theme.DARK) }