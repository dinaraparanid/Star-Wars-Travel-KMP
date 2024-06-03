package com.paranid5.star_wars_travel.data.ktor.wookiepedia

import com.fleeksoft.ksoup.nodes.Element
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.domain.entities.SwapiPlanet
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.SocietalInformation
import com.paranid5.star_wars_travel.domain.utils.toLongOrZero
import kotlinx.coroutines.withContext

internal suspend inline fun Element.societalInfo(planet: SwapiPlanet) =
    withContext(DataDispatcher) {
        SocietalInformation(
            population = planet.population.toLongOrZero(),
            nativeSpecies = info("species"),
            otherSpecies = info("otherspecies"),
            primaryLanguages = info("language"),
            government = info("government").firstOrNull(),
            majorCities = info("cities"),
        )
    }

internal fun defaultSocInfo(planet: SwapiPlanet) =
    SocietalInformation(population = planet.population.toLongOrZero())