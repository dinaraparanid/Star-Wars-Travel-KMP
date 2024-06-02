package com.paranid5.star_wars_travel.feature.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent

private val SEPARATOR_SIZE = 1.dp

@Composable
fun SettingsScreen(
    settingsComponent: SettingsComponent,
    modifier: Modifier = Modifier
) = Column(modifier) {
    ThemeMenu(
        settingsComponent = settingsComponent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = AppTheme.dimensions.padding.large,
                bottom = AppTheme.dimensions.padding.extraSmall
            )
    )

    AlphaSeparator()
}

@Composable
private fun AlphaSeparator() = Spacer(
    Modifier
        .fillMaxWidth()
        .height(SEPARATOR_SIZE)
        .background(AppTheme.colors.transparentUtility)
)