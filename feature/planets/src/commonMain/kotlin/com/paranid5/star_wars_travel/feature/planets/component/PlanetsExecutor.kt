package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.Label
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStoreProvider.Msg
import kotlinx.coroutines.Dispatchers

internal class PlanetsExecutor : CoroutineExecutor<UiIntent, Unit, State, Msg, Label>(Dispatchers.Default) {
    override fun executeIntent(intent: UiIntent) = when (intent) {
        is UiIntent.ReselectRegion -> reselectRegion(intent.region)
        is UiIntent.UpdateSearchText -> dispatch(Msg.UpdateSearchText(intent.text))
        is UiIntent.ShowPlanet -> publish(Label.ShowPlanet(intent.planet))
    }

    private fun reselectRegion(region: String?) = when (region) {
        null -> dispatch(Msg.ClearRegions)

        in state().selectedRegions -> when (state().selectedRegions.size) {
            1 -> dispatch(Msg.ClearRegions)
            else -> dispatch(Msg.RemoveRegion(region))
        }

        else -> dispatch(Msg.AddRegion(region))
    }
}