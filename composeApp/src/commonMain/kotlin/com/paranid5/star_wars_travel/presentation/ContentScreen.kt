package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.paranid5.star_wars_travel.component.root.RootChild
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.feature.about_app.presentation.AboutAppScreen
import com.paranid5.star_wars_travel.feature.planets.presentation.PlanetsScreen
import com.paranid5.star_wars_travel.feature.settings.presentation.SettingsScreen

@Composable
internal fun ContentScreen(
    rootComponent: RootComponent,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val direction = LocalLayoutDirection.current
    val padding = dimensions.padding

    Children(
        stack = rootComponent.stack,
        animation = stackAnimation(fade()),
        modifier = modifier.padding(
            top = padding.zero,
            bottom = paddingValues.calculateBottomPadding(),
            start = paddingValues.calculateStartPadding(direction),
            end = paddingValues.calculateEndPadding(direction),
        )
    ) {
        when (val child = it.instance) {
            is RootChild.Planets -> PlanetsScreen(
                planetsComponent = child.component,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding() + padding.big),
            )

            is RootChild.Settings -> SettingsScreen(
                settingsComponent = child.component,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding() + padding.extraMedium,
                        start = padding.small,
                        end = padding.small,
                    ),
            )

            is RootChild.AboutApp -> AboutAppScreen(
                aboutAppComponent = child.component,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding() + padding.small,
                        start = padding.small,
                        end = padding.small,
                    ),
            )
        }
    }
}