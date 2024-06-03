package com.paranid5.star_wars_travel.feature.planets.component

import androidx.paging.PagingData
import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class PlanetsComponentImpl(componentContext: ComponentContext) :
    PlanetsComponent,
    ComponentContext by componentContext {
    private val _stateFlow by lazy { MutableStateFlow(PlanetsState.default) }
    override val stateFlow by lazy { _stateFlow.asStateFlow() }

    override val planetsPagedFlow: Flow<PagingData<PlanetUiState>>
        get() = TODO("Not yet implemented")

    override val regionsPagedFlow: Flow<PagingData<RegionUiState>>
        get() = TODO("Not yet implemented")

    class Factory : PlanetsComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetsComponent =
            PlanetsComponentImpl(componentContext)
    }
}
