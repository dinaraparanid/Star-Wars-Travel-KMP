package com.paranid5.star_wars_travel.feature.planet.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.core.component.getComponentState
import com.paranid5.star_wars_travel.core.component.onInitial
import com.paranid5.star_wars_travel.core.ui.UiState
import com.paranid5.star_wars_travel.core.ui.toUiStateIfNotNull
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.data.PlanetsRepository
import com.paranid5.star_wars_travel.data.ktor.wookiepedia.loadInterestCover
import com.paranid5.star_wars_travel.domain.utils.updateState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.InterestUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class PlanetComponentImpl(
    componentContext: ComponentContext,
    initialPlanet: PlanetUiState,
    private val planetsRepository: PlanetsRepository,
    private val onBack: () -> Unit,
) : PlanetComponent,
    ComponentContext by componentContext {
    private companion object {
        const val SNACKBAR_SHOWN_MS = 3000L
    }

    private val componentState = getComponentState(
        defaultState = PlanetState(initialPlanet)
    )

    private val _stateFlow = MutableStateFlow(componentState.value)
    override val stateFlow = _stateFlow.asStateFlow()

    init {
        componentState.onInitial {
            updateInterests(initialPlanet.updateInterestsCovers { UiState.Loading })

            componentScope.launch(DataDispatcher) {
                val loadedInterests = initialPlanet.updateInterestsCovers { (value, _) ->
                    loadInterestCover(value).toUiStateIfNotNull()
                }

                launch(DataDispatcher) { storeInterestsAsync(loadedInterests) }

                updateInterests(loadedInterests)
            }
        }
    }

    override fun onUiIntent(intent: PlanetUiIntent) {
        when (intent) {
            PlanetUiIntent.GoBack -> onBack()
            PlanetUiIntent.ChangeDescriptionVisibility -> changeDescriptionVisibility()
            PlanetUiIntent.HideTravelSnackbar -> changeTravelSnackbarVisibility(isShown = false)
            PlanetUiIntent.ShowTravelSnackbar -> componentScope.launch { showTravelSnackbar() }
        }
    }

    private fun storeInterestsAsync(interests: ImmutableList<InterestUiState>) =
        planetsRepository.updateInterestsAsync(interests.map(InterestUiState::toInterest))

    private fun updateInterests(interests: ImmutableList<InterestUiState>) =
        _stateFlow.updateState {
            copy(
                planet = planet.copy(
                    physicalInformation = planet
                        .physicalInformation
                        .copy(interests = interests),
                )
            )
        }

    private fun changeDescriptionVisibility() =
        _stateFlow.updateState { copy(isDescriptionShown = isDescriptionShown.not()) }

    private fun changeTravelSnackbarVisibility(isShown: Boolean) =
        _stateFlow.updateState { copy(isTravelSnackbarShown = isShown) }

    private suspend fun showTravelSnackbar() {
        changeTravelSnackbarVisibility(isShown = true)
        delay(SNACKBAR_SHOWN_MS)
        changeTravelSnackbarVisibility(isShown = false)
    }

    class Factory(private val planetsRepository: PlanetsRepository) : PlanetComponent.Factory {
        override fun create(
            componentContext: ComponentContext,
            initialPlanet: PlanetUiState,
            onBack: () -> Unit,
        ): PlanetComponent = PlanetComponentImpl(
            componentContext = componentContext,
            initialPlanet = initialPlanet,
            planetsRepository = planetsRepository,
            onBack = onBack,
        )
    }
}

private inline fun PlanetUiState.updateInterestsCovers(
    transform: (InterestUiState) -> UiState<String>
): ImmutableList<InterestUiState> =
    physicalInformation
        .interests
        .map { InterestUiState(it.value, transform(it)) }
        .toImmutableList()