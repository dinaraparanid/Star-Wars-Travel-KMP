package com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia

import kotlinx.serialization.Serializable

@Serializable
data class AstrographicalInformation(
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val region: List<String> = emptyList(),
    val sector: String? = null,
    val system: String? = null,
    val moons: Int = 0,
    val tradeRoutes: List<String> = emptyList(),
)