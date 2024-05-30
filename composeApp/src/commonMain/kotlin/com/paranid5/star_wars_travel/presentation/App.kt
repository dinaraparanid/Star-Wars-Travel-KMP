package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.presentation.appbar.AppBar
import com.paranid5.star_wars_travel.presentation.ui.theme.AppTheme
import com.paranid5.star_wars_travel.presentation.ui.theme.provider.ThemeProvider
import org.koin.compose.koinInject

@Composable
fun App(
    modifier: Modifier = Modifier,
    themeProvider: ThemeProvider = koinInject(),
) {
    val theme by themeProvider.themeState.collectAsState()
    AppTheme(theme) { Box(modifier) { ScreenScaffold(Modifier.fillMaxSize()) } }
}

@Composable
private fun ScreenScaffold(modifier: Modifier = Modifier) {
    val backgroundColor = AppTheme.colors.background

    Scaffold(
        modifier = modifier,
        bottomBar = { AppBar() },
        contentColor = backgroundColor,
        content = { ContentScreen(paddingValues = it) }
    )
}