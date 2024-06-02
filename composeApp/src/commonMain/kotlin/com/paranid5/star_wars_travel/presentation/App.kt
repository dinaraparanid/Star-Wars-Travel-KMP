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
import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProvider
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.koin.compose.koinInject

@Composable
fun App(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
    themeProvider: ThemeProvider = koinInject(),
) {
    val theme by themeProvider.themeState.collectAsState()

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