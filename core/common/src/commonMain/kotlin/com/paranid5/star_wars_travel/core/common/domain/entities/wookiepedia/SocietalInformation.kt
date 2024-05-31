package com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia

import kotlinx.serialization.Serializable

@Serializable
data class SocietalInformation(
    val population: Long,
    val nativeSpecies: List<String> = emptyList(),
    val otherSpecies: List<String> = emptyList(),
    val primaryLanguages: List<String> = emptyList(),
    val government: String? = null,
    val majorCities: List<String> = emptyList()
)