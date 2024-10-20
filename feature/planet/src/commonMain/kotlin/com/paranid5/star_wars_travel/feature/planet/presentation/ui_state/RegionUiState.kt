package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class RegionUiState(
    val region: String,
    val isSelected: Boolean,
)
