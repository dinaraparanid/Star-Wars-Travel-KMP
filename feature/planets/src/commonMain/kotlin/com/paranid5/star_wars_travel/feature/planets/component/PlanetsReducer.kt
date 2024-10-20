package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.mvikotlin.core.store.Reducer
import com.paranid5.star_wars_travel.core.utils.extensions.buildImmutableList
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStoreProvider.Msg
import kotlinx.collections.immutable.persistentListOf

internal object PlanetsReducer : Reducer<State, Msg> {
    override fun State.reduce(msg: Msg): State = when (msg) {
        is Msg.ClearRegions ->
            copy(selectedRegions = persistentListOf(null))

        is Msg.AddRegion -> copy(
            selectedRegions = buildImmutableList {
                selectedRegions.forEach { reg -> reg?.let(this::add) }
                add(msg.region)
            }
        )

        is Msg.RemoveRegion -> copy(
            selectedRegions = buildImmutableList {
                selectedRegions.forEach { reg ->
                    reg.takeIf { it != msg.region }?.let(this::add)
                }
            }
        )

        is Msg.UpdateSearchText -> copy(searchText = msg.text)

        is Msg.ShowTravelSnackbar -> copy(isTravelSnackbarShown = true)

        is Msg.HideTravelSnackbar -> copy(isTravelSnackbarShown = false)
    }
}
