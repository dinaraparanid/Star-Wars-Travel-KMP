package com.paranid5.star_wars_travel.feature.planets.component

import androidx.paging.PagingData
import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import kotlinx.coroutines.flow.Flow

interface PlanetsComponent : ComponentContext, StateSource<PlanetsState> {
    val planetsPagedFlow: Flow<PagingData<PlanetUiState>>
    val regionsPagedFlow: Flow<PagingData<RegionUiState>>

    interface Factory {
        fun create(componentContext: ComponentContext): PlanetsComponent
    }
}