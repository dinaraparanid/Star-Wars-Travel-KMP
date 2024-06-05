package com.paranid5.star_wars_travel.feature.planets.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.planets.presentation.views.Planets
import com.paranid5.star_wars_travel.feature.planets.presentation.views.PlanetsSearchBar
import com.paranid5.star_wars_travel.feature.planets.presentation.views.PlanetsWelcomeLabel
import com.paranid5.star_wars_travel.feature.planets.presentation.views.region.RegionSelectors

@Composable
fun PlanetsScreen(
    planetsComponent: PlanetsComponent,
    modifier: Modifier = Modifier
) {
    val state by planetsComponent.stateFlow.collectAsState()
    val onUiIntent = planetsComponent::onUiIntent

    val regions = planetsComponent.regionsPagedFlow.collectAsLazyPagingItems()
    val planets = planetsComponent.planetsPagedFlow.collectAsLazyPagingItems()

    Column(modifier) {
        PlanetsWelcomeLabel(Modifier.fillMaxWidth())

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        PlanetsSearchBar(
            state = state,
            onUiIntent = onUiIntent,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        RegionSelectors(
            state = state,
            onUiIntent = onUiIntent,
            regions = regions,
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        Planets(
            planets = planets,
            onUiIntent = onUiIntent,
            modifier = Modifier.fillMaxWidth()
        )
    }
}