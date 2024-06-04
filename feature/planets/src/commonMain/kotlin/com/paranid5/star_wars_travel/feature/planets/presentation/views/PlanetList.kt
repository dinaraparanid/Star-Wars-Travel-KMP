package com.paranid5.star_wars_travel.feature.planets.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.LazyPagingItems
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import com.paranid5.star_wars_travel.feature.planets.presentation.views.item.PlanetItem

@Suppress("NonSkippableComposable")
@Composable
internal fun PlanetList(
    planets: LazyPagingItems<PlanetUiState>,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.padding.small),
    ) {
        items(planets.itemCount, key = { it }) { index ->
            planets[index]?.let {
                PlanetItem(
                    planet = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onUiIntent(UiIntent.ShowPlanet(planet = it)) }
                )
            }

            Spacer(Modifier.height(AppTheme.dimensions.padding.small))
        }
    }
}