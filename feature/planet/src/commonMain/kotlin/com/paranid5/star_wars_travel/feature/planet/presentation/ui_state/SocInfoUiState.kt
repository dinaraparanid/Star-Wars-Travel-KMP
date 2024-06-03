package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.SocietalInformation
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class SocInfoUiState(
    val population: Long,
    val nativeSpecies: List<String> = emptyList(),
    val otherSpecies: List<String> = emptyList(),
    val primaryLanguages: List<String> = emptyList(),
    val government: String? = null,
    val majorCities: List<String> = emptyList()
) {
    constructor(infoEntity: SocietalInformation) : this(
        population = infoEntity.population,
        nativeSpecies = infoEntity.nativeSpecies,
        otherSpecies = infoEntity.otherSpecies,
        primaryLanguages = infoEntity.primaryLanguages,
        government = infoEntity.government,
        majorCities = infoEntity.majorCities
    )
}