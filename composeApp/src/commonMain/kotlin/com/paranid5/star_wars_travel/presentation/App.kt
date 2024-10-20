package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveSurface
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@OptIn(ExperimentalCoilApi::class, ExperimentalAdaptiveApi::class)
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

        AdaptiveSurface(
            modifier = modifier.background(brush = colors.background.gradient),
            color = Color.Transparent,
        ) {
            MainScreen(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
