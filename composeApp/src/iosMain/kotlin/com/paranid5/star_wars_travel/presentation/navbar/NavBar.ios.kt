package com.paranid5.star_wars_travel.presentation.navbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.component.root.RootComponent

@Composable
internal actual fun NavBar(
    rootComponent: RootComponent,
    modifier: Modifier,
) = NavBarMobile(rootComponent, modifier)