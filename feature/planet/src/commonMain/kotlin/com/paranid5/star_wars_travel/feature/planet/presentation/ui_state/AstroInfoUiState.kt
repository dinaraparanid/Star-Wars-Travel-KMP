package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.AstrographicalInformation
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class AstroInfoUiState(
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val region: List<String> = emptyList(),
    val sector: String? = null,
    val system: String? = null,
    val moons: Int = 0,
    val tradeRoutes: List<String> = emptyList(),
) {
    constructor(infoEntity: AstrographicalInformation) : this(
        rotationPeriod = infoEntity.rotationPeriod,
        orbitalPeriod = infoEntity.orbitalPeriod,
        region = infoEntity.region,
        sector = infoEntity.sector,
        system = infoEntity.system,
        moons = infoEntity.moons,
        tradeRoutes = infoEntity.tradeRoutes
    )
}