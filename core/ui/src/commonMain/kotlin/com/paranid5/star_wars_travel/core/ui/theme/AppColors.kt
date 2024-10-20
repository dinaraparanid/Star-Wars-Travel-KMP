package com.paranid5.star_wars_travel.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.materialkolor.ktx.darken
import com.materialkolor.ktx.lighten
import com.paranid5.star_wars_travel.core.ui.CharlestonGreen
import com.paranid5.star_wars_travel.core.ui.ChineseBlack
import com.paranid5.star_wars_travel.core.ui.ChineseSilver
import com.paranid5.star_wars_travel.core.ui.Cultured
import com.paranid5.star_wars_travel.core.ui.OuterSpace
import com.paranid5.star_wars_travel.core.ui.StarWarsHologram
import com.paranid5.star_wars_travel.core.ui.StarWarsYellow
import com.paranid5.star_wars_travel.core.ui.TransparentUtilityDark
import com.paranid5.star_wars_travel.core.ui.TransparentUtilityLight
import com.paranid5.star_wars_travel.domain.entities.Theme

@Immutable
data class AppColors(
    val primary: Color,
    val transparentUtility: Color,
    val background: AppBackgroundColors,
    val text: AppTextColors,
    val appBar: AppBarColors,
    val chips: AppChipsColors,
) {
    companion object {
        internal fun create(theme: Theme) = when (theme) {
            Theme.DARK -> dark()
            Theme.LIGHT -> light()
        }

        private fun dark() = AppColors(
            primary = StarWarsYellow,
            transparentUtility = TransparentUtilityDark,
            background = AppBackgroundColors.dark(),
            text = AppTextColors.dark(),
            appBar = AppBarColors.default(),
            chips = AppChipsColors.default(),
        )

        private fun light() = AppColors(
            primary = StarWarsYellow,
            transparentUtility = TransparentUtilityLight,
            background = AppBackgroundColors.light(),
            text = AppTextColors.light(),
            appBar = AppBarColors.default(),
            chips = AppChipsColors.default(),
        )
    }
}

@Immutable
data class AppBackgroundColors(
    val primary: Color,
    val alternative: Color,
    val gradient: Brush,
) {
    companion object {
        internal fun dark() = AppBackgroundColors(
            primary = OuterSpace,
            alternative = ChineseSilver,
            gradient = Brush.linearGradient(
                listOf(
                    OuterSpace.lighten(ratio = 1.5F),
                    OuterSpace.darken(ratio = 1.5F),
                ),
            ),
        )

        internal fun light() = AppBackgroundColors(
            primary = ChineseSilver,
            alternative = OuterSpace,
            gradient = Brush.linearGradient(
                listOf(
                    ChineseSilver.lighten(ratio = 1.5F),
                    ChineseSilver.darken(ratio = 1.5F),
                ),
            ),
        )
    }
}

@Immutable
data class AppTextColors(
    val primary: Color,
    val onButton: Color,
    val itemDescription: Color,
    val placeholder: Color,
) {
    companion object {
        internal fun dark() = AppTextColors(
            primary = Cultured,
            onButton = ChineseBlack,
            itemDescription = Cultured,
            placeholder = Cultured.copy(alpha = 0.5F),
        )

        internal fun light() = AppTextColors(
            primary = ChineseBlack,
            onButton = ChineseBlack,
            itemDescription = Cultured,
            placeholder = ChineseBlack.copy(alpha = 0.5F),
        )
    }
}

@Immutable
data class AppBarColors(
    val background: Color,
    val selectedTab: Color,
    val unselectedTab: Color,
) {
    companion object {
        internal fun default() = AppBarColors(
            background = CharlestonGreen,
            selectedTab = StarWarsYellow,
            unselectedTab = StarWarsHologram,
        )
    }
}

@Immutable
data class AppChipsColors(
    val selected: Color,
    val unselected: Color,
) {
    companion object {
        internal fun default() = AppChipsColors(
            selected = ChineseBlack,
            unselected = ChineseSilver,
        )
    }
}

internal val LocalColors = staticCompositionLocalOf { AppColors.create(Theme.DARK) }