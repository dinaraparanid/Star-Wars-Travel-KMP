package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.core.ui.UiState
import com.paranid5.star_wars_travel.core.ui.toUiState
import com.paranid5.star_wars_travel.core.ui.toUiStateIfNotNull
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class PlanetUiState(
    val title: String,
    val astrographicalInformation: AstroInfoUiState,
    val physicalInformation: PhysInfoUiState,
    val societalInformation: SocInfoUiState,
    val description: String? = null,
    val coverUrl: UiState<String> = UiState.Undefined,
) {
    constructor(planetEntity: WookiepediaPlanet) : this(
        title = planetEntity.title,
        astrographicalInformation = AstroInfoUiState(planetEntity.astrographicalInformation),
        physicalInformation = PhysInfoUiState(planetEntity.physicalInformation),
        societalInformation = SocInfoUiState(planetEntity.societalInformation),
        description = planetEntity.description,
        coverUrl = planetEntity.coverUrl.toUiStateIfNotNull()
    )
}

inline val PlanetUiState.mainRegion
    get() = astrographicalInformation.region.firstOrNull()