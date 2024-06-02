package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.domain.entities.Theme

@Composable
fun App(
    rootComponent: RootComponent,
    storageRepository: StorageRepository,
    modifier: Modifier = Modifier,
) {
    val theme by storageRepository
        .themeDataSource
        .themeFlow
        .collectAsState(initial = Theme.DARK)

    AppTheme(theme) {
        Surface(
            modifier = modifier.background(brush = AppTheme.colors.backgroundGradient),
            color = Color.Transparent
        ) {
            MainScreen(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}