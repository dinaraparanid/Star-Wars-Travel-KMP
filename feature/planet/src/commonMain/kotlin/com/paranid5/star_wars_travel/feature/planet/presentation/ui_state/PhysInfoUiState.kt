package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.PhysicalInformation
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class PhysInfoUiState(
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: Int,
    val diameter: Int = 0,
    val planetClass: String? = null,
    val atmosphere: String? = null,
    val interests: List<InterestUiState> = emptyList(),
    val flora: List<String> = emptyList(),
    val fauna: List<String> = emptyList()
) {
    constructor(infoEntity: PhysicalInformation) : this(
        climate = infoEntity.climate,
        gravity = infoEntity.gravity,
        terrain = infoEntity.terrain,
        surfaceWater = infoEntity.surfaceWater,
        diameter = infoEntity.diameter,
        planetClass = infoEntity.planetClass,
        atmosphere = infoEntity.atmosphere,
        interests = infoEntity.interests.map(::InterestUiState),
        flora = infoEntity.flora,
        fauna = infoEntity.fauna
    )
}