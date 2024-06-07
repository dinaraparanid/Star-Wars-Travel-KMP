package com.paranid5.star_wars_travel.feature.planet.component

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class PlanetState(
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