package com.paranid5.star_wars_travel.feature.planet.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.core.component.UiIntentHandler
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState

internal const val HIDDEN_MAX_LINES = 3

interface PlanetComponent :
    ComponentContext,
    StateSource<PlanetState>,
    UiIntentHandler<PlanetUiIntent> {
    interface Factory {
        fun create(
            componentContext: ComponentContext,
            initialPlanet: PlanetUiState,
            onBack: () -> Unit,
        ): PlanetComponent
    }
}