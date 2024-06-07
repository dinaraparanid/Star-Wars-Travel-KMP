package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.SocietalInformation
import com.paranid5.star_wars_travel.domain.utils.ImmutableListSerializer
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class SocInfoUiState(
    val population: Long,
    @Serializable(with = ImmutableListSerializer::class)
    val nativeSpecies: ImmutableList<String> = persistentListOf(),
    @Serializable(with = ImmutableListSerializer::class)
    val otherSpecies: ImmutableList<String> = persistentListOf(),
    @Serializable(with = ImmutableListSerializer::class)
    val primaryLanguages: ImmutableList<String> = persistentListOf(),
    val government: String? = null,
    @Serializable(with = ImmutableListSerializer::class)
    val majorCities: ImmutableList<String> = persistentListOf(),
) {
    constructor(infoEntity: SocietalInformation) : this(
        population = infoEntity.population,
        nativeSpecies = infoEntity.nativeSpecies.toImmutableList(),
        otherSpecies = infoEntity.otherSpecies.toImmutableList(),
        primaryLanguages = infoEntity.primaryLanguages.toImmutableList(),
        government = infoEntity.government,
        majorCities = infoEntity.majorCities.toImmutableList(),
    )
}