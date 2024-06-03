package com.paranid5.star_wars_travel.data.ktor.wookiepedia

import com.fleeksoft.ksoup.nodes.Element
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.domain.entities.SwapiPlanet
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.AstrographicalInformation
import com.paranid5.star_wars_travel.domain.utils.toIntOrZero
import kotlinx.coroutines.withContext

internal suspend inline fun Element.astrographicalInfo(planet: SwapiPlanet) =
    withContext(DataDispatcher) {
        AstrographicalInformation(
            rotationPeriod = planet.rotationPeriod.toIntOrZero(),
            orbitalPeriod = planet.orbitalPeriod.toIntOrZero(),
            region = info("region"),
            sector = info("sector").firstOrNull(),
            system = info("system").firstOrNull(),
            moons = info("moons").firstOrNull().toIntOrZero(),
            tradeRoutes = info("routes")
        )
    }

internal fun defaultAstroInfo(planet: SwapiPlanet) =
    AstrographicalInformation(
        rotationPeriod = planet.rotationPeriod.toIntOrZero(),
        orbitalPeriod = planet.orbitalPeriod.toIntOrZero(),
    )