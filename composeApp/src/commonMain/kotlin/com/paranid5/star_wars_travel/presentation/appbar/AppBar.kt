package com.paranid5.star_wars_travel.presentation.appbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.value.operator.map
import com.paranid5.star_wars_travel.component.root.RootChild
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.component.root.RootUiIntent
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.about_app
import com.paranid5.star_wars_travel.core.resources.planet
import com.paranid5.star_wars_travel.core.resources.planets
import com.paranid5.star_wars_travel.core.resources.question
import com.paranid5.star_wars_travel.core.resources.settings
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AppBar(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) {
    val currentScreen by rememberCurrentScreen(rootComponent)
    val onUiIntent = rootComponent::onUiIntent

    BottomAppBar(
        containerColor = AppTheme.colors.appBarColor,
        modifier = modifier.clip(
            RoundedCornerShape(
                topStart = AppTheme.dimensions.corners.medium,
                topEnd = AppTheme.dimensions.corners.medium
            )
        )
    ) {
        AppBarItem(
            title = stringResource(Res.string.planets),
            image = painterResource(Res.drawable.planet),
            isScreenCurrent = currentScreen is RootChild.Planets,
            modifier = Modifier.weight(1F),
            onClick = { onUiIntent(RootUiIntent.ShowPlanets) }
        )

        AppBarItem(
            title = stringResource(Res.string.settings),
            image = painterResource(Res.drawable.settings),
            isScreenCurrent = currentScreen is RootChild.Settings,
            modifier = Modifier.weight(1F),
            onClick = { onUiIntent(RootUiIntent.ShowSettings) }
        )

        AppBarItem(
            title = stringResource(Res.string.about_app),
            image = painterResource(Res.drawable.question),
            isScreenCurrent = currentScreen is RootChild.AboutApp,
            modifier = Modifier.weight(1F),
            onClick = { onUiIntent(RootUiIntent.ShowAboutApp) }
        )
    }
}

@Composable
private fun rememberCurrentScreen(rootComponent: RootComponent) =
    rootComponent.stack.map { it.active.instance }.subscribeAsState()