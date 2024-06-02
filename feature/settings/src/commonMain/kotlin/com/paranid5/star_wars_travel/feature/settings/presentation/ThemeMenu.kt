package com.paranid5.star_wars_travel.feature.settings.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.dark_mode
import com.paranid5.star_wars_travel.core.resources.light_mode
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.domain.entities.Theme
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsUiIntent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val THEME_ICON_SIZE = 32.dp

@Composable
internal fun ThemeMenu(
    settingsComponent: SettingsComponent,
    modifier: Modifier = Modifier
) {
    val theme by settingsComponent.themeFlow.collectAsState(Theme.DARK)
    val onUiIntent = settingsComponent::onUiIntent

    when (theme) {
        Theme.LIGHT -> ThemeMenuImpl(
            iconPainter = painterResource(Res.drawable.light_mode),
            text = stringResource(Res.string.light_mode),
            modifier = modifier.clickable { onUiIntent(SettingsUiIntent.ResetTheme(Theme.DARK)) }
        )

        Theme.DARK -> ThemeMenuImpl(
            iconPainter = painterResource(Res.drawable.dark_mode),
            text = stringResource(Res.string.dark_mode),
            modifier = modifier.clickable { onUiIntent(SettingsUiIntent.ResetTheme(Theme.LIGHT)) }
        )
    }
}

@Composable
private fun ThemeMenuImpl(
    iconPainter: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    val padding = AppTheme.dimensions.padding

    Row(modifier) {
        Image(
            painter = iconPainter,
            contentDescription = text,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(THEME_ICON_SIZE)
                .padding(start = padding.extraSmall)
                .align(Alignment.CenterVertically)
        )

        Spacer(Modifier.width(padding.small))

        Text(
            text = text,
            color = AppTheme.colors.onBackground,
            style = AppTheme.typography.body,
            modifier = Modifier.padding(top = padding.small, bottom = padding.extraSmall)
        )
    }
}