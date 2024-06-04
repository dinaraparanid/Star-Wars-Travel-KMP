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
    constructor() : this(
        count = 0,
        next = null,
        previous = null,
        results = emptyList(),
    )
}