package com.paranid5.star_wars_travel.feature.planets.utils

import androidx.paging.PagingData
import androidx.paging.filter
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState

internal fun PagingData<PlanetUiState>.filterByRegions(regions: List<String?>) =
    when {
        null in regions -> this
        else -> filter { it.mainRegion in regions }
    }

internal fun PagingData<PlanetUiState>.filterBySearchQuery(searchText: String) =
    filter { searchText.lowercase() in it.title.lowercase() }
