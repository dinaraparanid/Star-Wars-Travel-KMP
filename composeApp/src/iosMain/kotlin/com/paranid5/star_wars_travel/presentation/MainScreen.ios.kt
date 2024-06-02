package com.paranid5.star_wars_travel.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.component.root.RootComponent

@Composable
internal actual fun MainScreen(
    rootComponent: RootComponent,
    modifier: Modifier
) = MainScreenMobile(rootComponent, modifier)