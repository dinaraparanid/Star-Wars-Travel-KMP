package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.Label
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent

internal class PlanetsStoreProvider(private val storeFactory: StoreFactory) {
    sealed interface Msg {
        data object ClearRegions : Msg
        data class RemoveRegion(val region: String?) : Msg
        data class AddRegion(val region: String?) : Msg
        data class UpdateSearchText(val text: String) : Msg
    }

    fun provide(initialState: State): PlanetsStore = object :
        PlanetsStore,
        Store<UiIntent, State, Label> by storeFactory.create(
            name = "PlanetsStore",
            initialState = initialState,
            executorFactory = ::PlanetsExecutor,
            reducer = PlanetsReducer,
        ) {}

    class Factory(private val storeFactory: StoreFactory) {
        fun create() = PlanetsStoreProvider(storeFactory)
    }
}