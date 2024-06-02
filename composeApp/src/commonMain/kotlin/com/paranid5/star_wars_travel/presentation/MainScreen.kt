package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.presentation.navbar.NavBar

@Composable
internal expect fun MainScreen(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
)

@Composable
internal fun MainScreenMobile(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = Scaffold(
    modifier = modifier,
    bottomBar = { NavBar(rootComponent) },
    backgroundColor = Color.Transparent,
    content = { ContentScreen(rootComponent, paddingValues = it) }
)

@Composable
internal fun MainScreenPC(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = Row(modifier) {
    NavBar(rootComponent)

    Scaffold(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        content = { ContentScreen(rootComponent, paddingValues = it) }
    )
}
