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
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.core.ui.utils.clickableWithRipple
import com.paranid5.star_wars_travel.domain.entities.Theme
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsUiIntent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val ThemeIconSize = 32.dp

@Composable
internal fun ThemeMenu(
    settingsComponent: SettingsComponent,
    modifier: Modifier = Modifier,
) {
    val state by settingsComponent.stateFlow.collectAsState()
    val onUiIntent = settingsComponent::onUiIntent

    when (state.theme) {
        Theme.LIGHT -> ThemeMenuImpl(
            iconPainter = painterResource(Res.drawable.light_mode),
            text = stringResource(Res.string.light_mode),
            modifier = modifier.clickable {
                onUiIntent(SettingsUiIntent.ResetTheme(Theme.DARK))
            },
        )

        Theme.DARK -> ThemeMenuImpl(
            iconPainter = painterResource(Res.drawable.dark_mode),
            text = stringResource(Res.string.dark_mode),
            modifier = modifier.clickable {
                onUiIntent(SettingsUiIntent.ResetTheme(Theme.LIGHT))
            }
        )
    }
}

@Composable
private fun ThemeMenuImpl(
    iconPainter: Painter,
    text: String,
    modifier: Modifier = Modifier
) = Row(modifier) {
    Image(
        painter = iconPainter,
        contentDescription = text,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(ThemeIconSize)
            .padding(start = dimensions.padding.extraSmall)
            .align(Alignment.CenterVertically),
    )

    Spacer(Modifier.width(dimensions.padding.small))

    Text(
        text = text,
        color = colors.text.primary,
        style = typography.body,
        modifier = Modifier.padding(
            top = dimensions.padding.small,
            bottom = dimensions.padding.extraSmall,
        )
    )
}
