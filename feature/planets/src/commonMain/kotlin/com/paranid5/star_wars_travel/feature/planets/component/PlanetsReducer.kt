package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.mvikotlin.core.store.Reducer
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStoreProvider.Msg
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

internal object PlanetsReducer : Reducer<State, Msg> {
    override fun State.reduce(msg: Msg): State = when (msg) {
        is Msg.ClearRegions ->
            copy(selectedRegions = persistentListOf(null))

        is Msg.AddRegion ->
            copy(selectedRegions = (selectedRegions - null + msg.region).toImmutableList())

        is Msg.RemoveRegion ->
            copy(selectedRegions = (selectedRegions - msg.region).toImmutableList())

        is Msg.UpdateSearchText -> copy(searchText = msg.text)
    }
}