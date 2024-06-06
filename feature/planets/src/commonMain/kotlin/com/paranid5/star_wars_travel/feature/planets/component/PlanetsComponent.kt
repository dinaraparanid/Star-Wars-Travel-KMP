package com.paranid5.star_wars_travel.feature.planets.component

import androidx.paging.PagingData
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.core.component.UiIntentHandler
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PlanetsComponent :
    ComponentContext,
    StateSource<State>,
    UiIntentHandler<UiIntent> {
    val childSlot: StateFlow<ChildSlot<*, Child>>

    sealed interface Child {
        data class Planet internal constructor(
            internal val component: PlanetComponent
        ) : Child
    }

    val planetsPagedFlow: Flow<PagingData<PlanetUiState>>
    val regionsPagedFlow: Flow<PagingData<RegionUiState>>

    interface Factory {
        fun create(componentContext: ComponentContext): PlanetsComponent
    }
}