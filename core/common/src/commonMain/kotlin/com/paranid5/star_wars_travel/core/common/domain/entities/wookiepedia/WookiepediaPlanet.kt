package com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia

import kotlinx.serialization.Serializable

@Serializable
data class WookiepediaPlanet(
    val title: String,
    val edited: String,
    val pageNumber: Int,
    val astrographicalInformation: AstrographicalInformation,
    val physicalInformation: PhysicalInformation,
    val societalInformation: SocietalInformation,
    val description: String? = null,
    val coverUrl: String? = null,
)