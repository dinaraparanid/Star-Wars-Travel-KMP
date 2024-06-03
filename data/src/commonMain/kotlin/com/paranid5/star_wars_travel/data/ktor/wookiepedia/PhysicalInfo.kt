package com.paranid5.star_wars_travel.data.ktor.wookiepedia

import com.fleeksoft.ksoup.nodes.Element
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.domain.entities.SwapiPlanet
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.PhysicalInformation
import com.paranid5.star_wars_travel.domain.utils.toIntOrZero
import kotlinx.coroutines.withContext

internal suspend inline fun Element.physicalInfo(planet: SwapiPlanet) =
    withContext(DataDispatcher) {
        PhysicalInformation(
            climate = planet.climate,
            gravity = planet.gravity,
            terrain = planet.terrain,
            surfaceWater = planet.surfaceWater.toIntOrZero(),
            diameter = planet.diameter.toIntOrZero(),
            planetClass = info("class").firstOrNull(),
            atmosphere = info("atmosphere").firstOrNull(),
            interest = info("interest").map { Interest(it, null) },
            flora = info("flora"),
            fauna = info("fauna")
        )
    }

internal fun defaultPhysInfo(planet: SwapiPlanet) =
    PhysicalInformation(
        climate = planet.climate,
        gravity = planet.gravity,
        terrain = planet.terrain,
        surfaceWater = planet.surfaceWater.toIntOrZero(),
        diameter = planet.diameter.toIntOrZero()
    )