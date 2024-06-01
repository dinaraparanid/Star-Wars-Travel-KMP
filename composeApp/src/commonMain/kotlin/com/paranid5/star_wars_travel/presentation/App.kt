package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.presentation.appbar.AppBar
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
    AppTheme(theme) { Box(modifier) { ScreenScaffold(rootComponent, Modifier.fillMaxSize()) } }
}

@Composable
private fun ScreenScaffold(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = AppTheme.colors.background

    Scaffold(
        modifier = modifier,
        bottomBar = { AppBar(rootComponent) },
        backgroundColor = backgroundColor,
        content = { ContentScreen(rootComponent, paddingValues = it) }
    )
}