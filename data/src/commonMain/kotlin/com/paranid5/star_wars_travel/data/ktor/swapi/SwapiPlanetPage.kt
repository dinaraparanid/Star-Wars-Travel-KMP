package com.paranid5.star_wars_travel.data.ktor.swapi

import com.paranid5.star_wars_travel.domain.entities.SwapiPlanet
import kotlinx.serialization.Serializable

@Serializable
data class SwapiPlanetPage(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<SwapiPlanet>,
) {
    internal companion object {
        inline val default
            get() = SwapiPlanetPage(0, null, null, emptyList())
    }
}