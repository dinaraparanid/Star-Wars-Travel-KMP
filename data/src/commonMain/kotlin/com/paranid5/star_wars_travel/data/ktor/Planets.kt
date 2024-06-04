package com.paranid5.star_wars_travel.data.ktor

import com.paranid5.star_wars_travel.data.ktor.swapi.SwapiPlanetPage
import com.paranid5.star_wars_travel.data.ktor.swapi.getSwapiPlanets
import com.paranid5.star_wars_travel.data.ktor.wookiepedia.PlanetDTO
import com.paranid5.star_wars_travel.domain.entities.PlanetPage
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import io.ktor.client.HttpClient

internal suspend fun HttpClient.getPlanets(pageNumber: Int = 1) =
    getSwapiPlanets(pageNumber)
        .getOrElse { SwapiPlanetPage() }
        .let { (_, next, previous, results) ->
            PlanetPage(
                next = next,
                previous = previous,
                planets = results
                    .map { PlanetDTO(planet = it, pageNumber = pageNumber) }
                    .sortedBy(WookiepediaPlanet::edited)
            )
        }