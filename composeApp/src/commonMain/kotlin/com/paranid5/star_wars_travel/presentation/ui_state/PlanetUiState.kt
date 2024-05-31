package com.paranid5.star_wars_travel.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia.WookiepediaPlanet
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class PlanetUiState(
    val title: String,
    val astrographicalInformation: AstroInfoUiState,
    val physicalInformation: PhysInfoUiState,
    val societalInformation: SocInfoUiState,
    val description: String? = null,
    val coverUrl: String? = null,
) {
    constructor(planetEntity: WookiepediaPlanet) : this(
        title = planetEntity.title,
        astrographicalInformation = AstroInfoUiState(planetEntity.astrographicalInformation),
        physicalInformation = PhysInfoUiState(planetEntity.physicalInformation),
        societalInformation = SocInfoUiState(planetEntity.societalInformation),
        description = planetEntity.description,
        coverUrl = planetEntity.coverUrl
    )
}

inline val PlanetUiState.mainRegion
    get() = astrographicalInformation.region.firstOrNull()