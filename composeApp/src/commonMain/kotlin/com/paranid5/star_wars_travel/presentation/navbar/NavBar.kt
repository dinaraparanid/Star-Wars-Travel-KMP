package com.paranid5.star_wars_travel.presentation.navbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
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

private val NAV_BAR_MAX_SIZE = 512.dp

@Composable
internal expect fun NavBar(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
)

@Composable
internal fun NavBarMobile(
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
        Spacer(Modifier.weight(1F))

        Row(Modifier.widthIn(max = NAV_BAR_MAX_SIZE)) {
            NavBarItem(
                title = stringResource(Res.string.planets),
                image = painterResource(Res.drawable.planet),
                isScreenCurrent = currentScreen is RootChild.Planets,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowPlanets) }
            )

            NavBarItem(
                title = stringResource(Res.string.settings),
                image = painterResource(Res.drawable.settings),
                isScreenCurrent = currentScreen is RootChild.Settings,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowSettings) }
            )

            NavBarItem(
                title = stringResource(Res.string.about_app),
                image = painterResource(Res.drawable.question),
                isScreenCurrent = currentScreen is RootChild.AboutApp,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowAboutApp) }
            )
        }

        Spacer(Modifier.weight(1F))
    }
}

@Composable
internal fun NavBarPC(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) {
    val currentScreen by rememberCurrentScreen(rootComponent)
    val onUiIntent = rootComponent::onUiIntent

    NavigationRail(
        modifier = modifier,
        containerColor = AppTheme.colors.appBarColor,
    ) {
        Spacer(Modifier.weight(1F))

        Column(Modifier.heightIn(max = NAV_BAR_MAX_SIZE)) {
            NavBarItem(
                title = stringResource(Res.string.planets),
                image = painterResource(Res.drawable.planet),
                isScreenCurrent = currentScreen is RootChild.Planets,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowPlanets) }
            )

            NavBarItem(
                title = stringResource(Res.string.settings),
                image = painterResource(Res.drawable.settings),
                isScreenCurrent = currentScreen is RootChild.Settings,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowSettings) }
            )

            NavBarItem(
                title = stringResource(Res.string.about_app),
                image = painterResource(Res.drawable.question),
                isScreenCurrent = currentScreen is RootChild.AboutApp,
                modifier = Modifier.weight(1F),
                onClick = { onUiIntent(RootUiIntent.ShowAboutApp) }
            )
        }

        Spacer(Modifier.weight(1F))
    }
}

@Composable
private fun rememberCurrentScreen(rootComponent: RootComponent) =
    rootComponent.stack.map { it.active.instance }.subscribeAsState()