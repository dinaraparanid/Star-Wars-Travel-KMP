package com.paranid5.star_wars_travel.feature.planet.component

import androidx.compose.runtime.Immutable
import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.core.component.UiIntentHandler
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent.State
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent.UiIntent
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import kotlinx.serialization.Serializable

internal const val HIDDEN_MAX_LINES = 3

interface PlanetComponent : ComponentContext, StateSource<State>, UiIntentHandler<UiIntent> {
    sealed interface UiIntent {
        data object GoBack : UiIntent
        data object ChangeDescriptionVisibility : UiIntent
        data object ShowTravelSnackbar : UiIntent
        data object HideTravelSnackbar : UiIntent
    }

    @Serializable
    @Immutable
    data class State(
        val planet: PlanetUiState,
        val isDescriptionShown: Boolean,
        val isTravelSnackbarShown: Boolean,
    ) {
        constructor(planet: PlanetUiState) : this(
            planet = planet,
            isDescriptionShown = false,
            isTravelSnackbarShown = false,
        )

        val descriptionMaxLines = if (isDescriptionShown) Int.MAX_VALUE else HIDDEN_MAX_LINES
    }

    interface Factory {
        fun create(
            componentContext: ComponentContext,
            initialPlanet: PlanetUiState,
            onBack: () -> Unit,
        ): PlanetComponent
    }
}