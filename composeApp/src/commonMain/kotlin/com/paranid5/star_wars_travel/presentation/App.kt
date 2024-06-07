package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun App(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) {
    val state by rootComponent.stateFlow.collectAsState()

    AppTheme(state.theme) {
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context).build()
        }

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
