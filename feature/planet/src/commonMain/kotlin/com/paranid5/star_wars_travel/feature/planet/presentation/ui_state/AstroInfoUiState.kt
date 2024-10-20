package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.AstrographicalInformation
import com.paranid5.star_wars_travel.domain.utils.ImmutableListSerializer
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class AstroInfoUiState(
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    @Serializable(with = ImmutableListSerializer::class)
    val region: ImmutableList<String> = persistentListOf(),
    val sector: String? = null,
    val system: String? = null,
    val moons: Int = 0,
    @Serializable(with = ImmutableListSerializer::class)
    val tradeRoutes: ImmutableList<String> = persistentListOf(),
) {
    constructor(infoEntity: AstrographicalInformation) : this(
        rotationPeriod = infoEntity.rotationPeriod,
        orbitalPeriod = infoEntity.orbitalPeriod,
        region = infoEntity.region.toImmutableList(),
        sector = infoEntity.sector,
        system = infoEntity.system,
        moons = infoEntity.moons,
        tradeRoutes = infoEntity.tradeRoutes.toImmutableList(),
    )
}
