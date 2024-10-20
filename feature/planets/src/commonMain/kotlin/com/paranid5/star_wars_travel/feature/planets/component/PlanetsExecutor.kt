package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.Label
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStoreProvider.Msg
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class PlanetsExecutor : CoroutineExecutor<UiIntent, Unit, State, Msg, Label>() {
    private companion object {
        const val SnackbarShownMs = 3000L
        const val LastRegion = 1
    }

    private var snackbarJob: Job? = null

    override fun executeIntent(intent: UiIntent) {
        when (intent) {
            is UiIntent.ReselectRegion -> reselectRegion(intent.region)
            is UiIntent.UpdateSearchText -> dispatch(Msg.UpdateSearchText(intent.text))
            is UiIntent.ShowPlanet -> publish(Label.ShowPlanet(intent.planet))
            is UiIntent.ShowTravelSnackbar -> snackbarJob = showTravelSnackbarThenHide()
            is UiIntent.HideTravelSnackbar -> hideTravelSnackbar()
        }
    }

    private fun reselectRegion(region: String?) = when (region) {
        null -> dispatch(Msg.ClearRegions)

        in state().selectedRegions -> when (state().selectedRegions.size) {
            LastRegion -> dispatch(Msg.ClearRegions)
            else -> dispatch(Msg.RemoveRegion(region))
        }

        else -> dispatch(Msg.AddRegion(region))
    }

    private fun showTravelSnackbarThenHide() = scope.launch {
        dispatch(Msg.ShowTravelSnackbar)
        delay(SnackbarShownMs)
        dispatch(Msg.HideTravelSnackbar)
    }

    private fun hideTravelSnackbar() {
        dispatch(Msg.HideTravelSnackbar)
        snackbarJob?.cancel()
    }
}
