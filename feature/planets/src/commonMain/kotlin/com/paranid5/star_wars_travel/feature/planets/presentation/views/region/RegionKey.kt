package com.paranid5.star_wars_travel.feature.planets.presentation.views.region

import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState

expect class RegionKey(region: String, isSelected: Boolean) {
    constructor(uiState: RegionUiState)
}