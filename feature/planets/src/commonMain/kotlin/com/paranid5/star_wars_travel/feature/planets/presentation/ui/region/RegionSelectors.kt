package com.paranid5.star_wars_travel.feature.planets.presentation.ui.region

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import app.cash.paging.compose.LazyPagingItems
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent

@Suppress("NonSkippableComposable")
@Composable
internal fun RegionSelectors(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    regions: LazyPagingItems<RegionUiState>,
    modifier: Modifier = Modifier,
) {
    val shownRegions by remember {
        derivedStateOf { regions.itemSnapshotList.distinct() }
    }

    fun regionKey(index: Int) = when (index) {
        0 -> RegionKey(region = "", isSelected = null in state.selectedRegions)
        else -> RegionKey(uiState = requireNotNull(shownRegions[index - 1]))
    }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensions.padding.small),
        contentPadding = PaddingValues(horizontal = dimensions.padding.extraMedium),
    ) {
        items(
            count = shownRegions.size + 1,
            key = { regionKey(it) }
        ) { i ->
            when (i) {
                0 -> RegionSelector(
                    region = null,
                    isSelected = null in state.selectedRegions,
                    onUiIntent = onUiIntent,
                )

                else -> {
                    val (region, isSelected) = requireNotNull(shownRegions[i - 1])

                    RegionSelector(
                        region = region,
                        isSelected = isSelected,
                        onUiIntent = onUiIntent,
                    )
                }
            }
        }
    }
}