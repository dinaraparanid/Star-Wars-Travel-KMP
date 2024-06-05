package com.paranid5.star_wars_travel.feature.planets.component

import androidx.compose.runtime.Immutable
import com.arkivanov.mvikotlin.core.store.Store
import com.paranid5.star_wars_travel.domain.utils.ImmutableListSerializer
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.Label
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

interface PlanetsStore : Store<UiIntent, State, Label> {
    sealed interface UiIntent {
        data class UpdateSearchText(val text: String) : UiIntent
        data class ReselectRegion(val region: String?) : UiIntent
        data class ShowPlanet(val planet: PlanetUiState) : UiIntent
        data object ShowTravelSnackbar : UiIntent
        data object HideTravelSnackbar : UiIntent
    }

    @Serializable
    @Immutable
    data class State(
        val searchText: String,
        @Serializable(with = ImmutableListSerializer::class)
        val selectedRegions: ImmutableList<String?>,
        val isTravelSnackbarShown: Boolean,
    ) {
        constructor() : this(
            searchText = "",
            selectedRegions = persistentListOf(null),
            isTravelSnackbarShown = false,
        )
    }

    sealed interface Label {
        data class ShowPlanet(val planet: PlanetUiState) : Label
    }
}
