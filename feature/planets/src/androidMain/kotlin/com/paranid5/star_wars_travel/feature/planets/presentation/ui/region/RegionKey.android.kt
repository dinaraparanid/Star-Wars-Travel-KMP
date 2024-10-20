package com.paranid5.star_wars_travel.feature.planets.presentation.ui.region

import android.os.Parcelable
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.RegionUiState
import kotlinx.parcelize.Parcelize

@Parcelize
internal actual class RegionKey actual constructor(
    private val region: String,
    private val isSelected: Boolean,
) : Parcelable {
    actual constructor(uiState: RegionUiState) : this(
        region = uiState.region,
        isSelected = uiState.isSelected,
    )
}
