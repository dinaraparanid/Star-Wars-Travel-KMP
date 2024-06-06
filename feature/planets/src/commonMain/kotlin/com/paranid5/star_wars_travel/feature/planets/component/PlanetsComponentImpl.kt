package com.paranid5.star_wars_travel.feature.planets.component

import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.core.component.getComponentStore
import com.paranid5.star_wars_travel.core.component.toStateFlow
import com.paranid5.star_wars_travel.data.PlanetsRepository
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.mainRegion
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent.Child
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponentImpl.Slot
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.Label
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import com.paranid5.star_wars_travel.feature.planets.utils.filterByRegions
import com.paranid5.star_wars_travel.feature.planets.utils.filterBySearchQuery
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

internal class PlanetsComponentImpl(
    componentContext: ComponentContext,
    private val storeFactory: PlanetsStoreProvider.Factory,
    private val planetComponentFactory: PlanetComponent.Factory,
    private val planetsRepository: PlanetsRepository,
) : PlanetsComponent,
    ComponentContext by componentContext {
    @Serializable
    sealed interface Slot {
        @Serializable
        data class Planet(val planet: PlanetUiState) : Slot
    }

    private val componentStore = getComponentStore(
        defaultState = State(),
        storeFactory = { storeFactory.create().provide(initialState = it) }
    )

    private val store = componentStore.value

    @OptIn(ExperimentalCoroutinesApi::class)
    override val stateFlow = store.stateFlow

    private val planetsUiFlow by lazy {
        planetsRepository
            .planetsPagedFlow
            .map { planets -> planets.map(::PlanetUiState) }
            .cachedIn(componentScope)
    }

    override val planetsPagedFlow by lazy {
        combine(
            planetsUiFlow,
            stateFlow
        ) { planets, (searchText, selectedRegions) ->
            when {
                searchText.isBlank() -> planets.filterByRegions(selectedRegions)
                else -> planets.filterBySearchQuery(searchText)
            }
        }
    }

    override val regionsPagedFlow by lazy {
        combine(
            planetsUiFlow,
            stateFlow
        ) { planets, (_, selectedRegions) ->
            planets
                .map { it.mainRegion.orEmpty() }
                .filter(String::isNotEmpty) to selectedRegions
        }.map { (allRegs, selectRegs) ->
            allRegs.map { RegionUiState(it, (it in selectRegs)) }
        }
    }

    private val childSlotNavigation = SlotNavigation<Slot>()

    override val childSlot: StateFlow<ChildSlot<*, Child>> = childSlot(
        source = childSlotNavigation,
        serializer = Slot.serializer(),
        childFactory = ::createChildSlot,
    ).toStateFlow()

    init {
        bind(lifecycle, BinderLifecycleMode.CREATE_DESTROY) {
            store.labels bindTo ::onLabel
        }
    }

    override fun onUiIntent(intent: UiIntent) = store.accept(intent)

    private fun createChildSlot(
        configuration: Slot,
        componentContext: ComponentContext,
    ) = when (configuration) {
        is Slot.Planet -> Child.Planet(buildPlanetComponent(configuration, componentContext))
    }

    private fun buildPlanetComponent(
        configuration: Slot.Planet,
        componentContext: ComponentContext,
    ) = planetComponentFactory.create(
        componentContext = componentContext,
        initialPlanet = configuration.planet,
        onBack = childSlotNavigation::dismiss
    )

    private fun onLabel(label: Label) = when (label) {
        is Label.ShowPlanet -> childSlotNavigation.activate(Slot.Planet(label.planet))
    }

    class Factory(
        private val storeFactory: PlanetsStoreProvider.Factory,
        private val planetComponentFactory: PlanetComponent.Factory,
        private val planetsRepository: PlanetsRepository,
    ) : PlanetsComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetsComponent =
            PlanetsComponentImpl(
                componentContext = componentContext,
                storeFactory = storeFactory,
                planetComponentFactory = planetComponentFactory,
                planetsRepository = planetsRepository,
            )
    }
}
