package com.paranid5.star_wars_travel.feature.planets.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent

private val CELL_SIZE = 300.dp

@Composable
internal fun Planets(
    planets: LazyPagingItems<PlanetUiState>,
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = CELL_SIZE),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.padding.small),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.padding.small),
    ) {
        items(planets.itemCount, key = { it }) { index ->
            planets[index]?.let {
                PlanetItem(
                    planet = it,
                    state = state,
                    onUiIntent = onUiIntent,
                    modifier = Modifier
                        .aspectRatio(1F)
                        .fillMaxSize()
                        .clickable { onUiIntent(UiIntent.ShowPlanet(planet = it)) }
                )
            }

            Spacer(Modifier.height(AppTheme.dimensions.padding.small))
        }
    }
}
