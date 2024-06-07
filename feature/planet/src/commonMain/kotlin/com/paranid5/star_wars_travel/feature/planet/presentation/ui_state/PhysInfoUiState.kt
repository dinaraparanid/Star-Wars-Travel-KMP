package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.PhysicalInformation
import com.paranid5.star_wars_travel.domain.utils.ImmutableListSerializer
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
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
    @Serializable(with = ImmutableListSerializer::class)
    val interests: ImmutableList<InterestUiState> = persistentListOf(),
    @Serializable(with = ImmutableListSerializer::class)
    val flora: ImmutableList<String> = persistentListOf(),
    @Serializable(with = ImmutableListSerializer::class)
    val fauna: ImmutableList<String> = persistentListOf(),
) {
    constructor(infoEntity: PhysicalInformation) : this(
        climate = infoEntity.climate,
        gravity = infoEntity.gravity,
        terrain = infoEntity.terrain,
        surfaceWater = infoEntity.surfaceWater,
        diameter = infoEntity.diameter,
        planetClass = infoEntity.planetClass,
        atmosphere = infoEntity.atmosphere,
        interests = infoEntity.interests.map(::InterestUiState).toImmutableList(),
        flora = infoEntity.flora.toImmutableList(),
        fauna = infoEntity.fauna.toImmutableList(),
    )
}