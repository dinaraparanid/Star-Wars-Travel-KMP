package com.paranid5.star_wars_travel.feature.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent

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
        .height(AppTheme.dimensions.separators.minimum)
        .background(AppTheme.colors.transparentUtility)
)