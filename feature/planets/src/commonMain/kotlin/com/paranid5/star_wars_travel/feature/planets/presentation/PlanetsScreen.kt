package com.paranid5.star_wars_travel.feature.planets.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import com.arkivanov.decompose.router.slot.ChildSlot
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.feature.planet.presentation.PlanetScreen
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent.Child
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import com.paranid5.star_wars_travel.feature.planets.presentation.views.Planets
import com.paranid5.star_wars_travel.feature.planets.presentation.views.PlanetsSearchBar
import com.paranid5.star_wars_travel.feature.planets.presentation.views.PlanetsWelcomeLabel
import com.paranid5.star_wars_travel.feature.planets.presentation.views.region.RegionSelectors
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State as PlanetsState

@Composable
fun PlanetsScreen(
    planetsComponent: PlanetsComponent,
    modifier: Modifier = Modifier,
) {
    val state by planetsComponent.stateFlow.collectAsState()
    val onUiIntent = planetsComponent::onUiIntent

    val regions = planetsComponent.regionsPagedFlow.collectAsLazyPagingItems()
    val planets = planetsComponent.planetsPagedFlow.collectAsLazyPagingItems()

    PlanetsScreenContent(
        state = state,
        onUiIntent = onUiIntent,
        regions = regions,
        planets = planets,
        modifier = modifier,
    )

    PlanetsScreenSlots(
        childSlotState = planetsComponent.childSlot.collectAsState(),
        modifier = Modifier
            .fillMaxSize()
            .background(colors.backgroundGradient)
            .zIndex(1F),
    )
}

@Composable
private fun PlanetsScreenContent(
    state: PlanetsState,
    onUiIntent: (UiIntent) -> Unit,
    regions: LazyPagingItems<RegionUiState>,
    planets: LazyPagingItems<PlanetUiState>,
    modifier: Modifier = Modifier,
) = Column(modifier) {
    val horizontalPaddingModifier = Modifier.padding(horizontal = dimensions.padding.extraMedium)

    PlanetsWelcomeLabel(horizontalPaddingModifier.fillMaxWidth())

    Spacer(Modifier.height(dimensions.padding.extraMedium))

    PlanetsSearchBar(
        state = state,
        onUiIntent = onUiIntent,
        modifier = horizontalPaddingModifier.fillMaxWidth(),
    )

    Spacer(Modifier.height(dimensions.padding.extraMedium))

    RegionSelectors(
        state = state,
        onUiIntent = onUiIntent,
        regions = regions,
    )

    Spacer(Modifier.height(dimensions.padding.extraMedium))

    Planets(
        planets = planets,
        state = state,
        onUiIntent = onUiIntent,
        modifier = horizontalPaddingModifier.fillMaxWidth(),
    )
}

@Composable
private fun PlanetsScreenSlots(
    childSlotState: State<ChildSlot<*, Child>>,
    modifier: Modifier = Modifier,
) {
    val childSlot by childSlotState

    when (val config = childSlot.child?.instance) {
        is Child.Planet -> PlanetScreen(planetComponent = config.component, modifier = modifier)
        null -> Unit
    }
}