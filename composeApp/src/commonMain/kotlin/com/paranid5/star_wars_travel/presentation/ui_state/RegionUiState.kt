package com.paranid5.star_wars_travel.presentation.ui_state

import androidx.compose.runtime.Immutable

@Immutable
data class RegionUiState(
    val region: String,
    val isSelected: Boolean
)