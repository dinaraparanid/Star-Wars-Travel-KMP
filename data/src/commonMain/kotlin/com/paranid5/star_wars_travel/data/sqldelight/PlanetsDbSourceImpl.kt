package com.paranid5.star_wars_travel.data.sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.db.SqlDriver
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.AstrographicalInformation
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.PhysicalInformation
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.SocietalInformation
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import com.paranid5.star_wars_travel.domain.utils.toIntOrZero
import com.paranid5.starwarstravel.data.PlanetsQueries
import com.paranid5.starwarstravel.data.SelectBaseItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

internal class PlanetsDbSourceImpl(driver: SqlDriver) :
    PlanetsDbSource,
    CoroutineScope by CoroutineScope(DataDispatcher) {
    private val queries by lazy {
        PlanetsQueries(driver)
    }

    private val mutex by lazy { Mutex() }

    override val planetsFlow
        get() = queries
            .selectBaseItems()
            .asFlow()
            .mapToList(DataDispatcher)
            .map { it.map(queries::parsePlanet) }

    override suspend fun getPlanets() =
        withContext(DataDispatcher) {
            queries
                .selectBaseItems()
                .executeAsList()
                .map(queries::parsePlanet)
        }

    override fun addPlanetAsync(planet: WookiepediaPlanet): Job =
        launch(DataDispatcher) {
            mutex.withLock { queries.addPlanet(planet) }
        }

    override fun updateInterestsAsync(interests: List<Interest>): Job =
        launch(DataDispatcher) {
            runCatching {
                mutex.withLock {
                    queries.transaction {
                        interests.forEach {
                            queries.updateInterest(it.coverUrl, it.value)
                        }
                    }
                }
            }
        }
}

internal fun PlanetsQueries.parsePlanet(item: SelectBaseItems) =
    WookiepediaPlanet(
        title = item.title,
        edited = item.edited,
        pageNumber = item.pageNumber.toInt(),
        description = item.description,
        coverUrl = item.coverUrl,
        astrographicalInformation = parseAstroInfo(item),
        physicalInformation = parsePhysicalInfo(item),
        societalInformation = parseSocInfo(item)
    )

internal fun PlanetsQueries.parseAstroInfo(item: SelectBaseItems) =
    AstrographicalInformation(
        rotationPeriod = item.rotationPeriod.toInt(),
        orbitalPeriod = item.orbitalPeriod.toInt(),
        sector = item.sector,
        system = item.system,
        moons = item.moons.toInt(),
        region = selectRegions(astroInfoId = item.astroInfoId)
            .executeAsList()
            .mapNotNull { it.region },
        tradeRoutes = selectTradeRoutes(astroInfoId = item.astroInfoId)
            .executeAsList()
            .mapNotNull { it.tradeRoute }
    )

internal fun PlanetsQueries.parsePhysicalInfo(item: SelectBaseItems) =
    PhysicalInformation(
        climate = item.climate,
        gravity = item.gravity,
        terrain = item.terrain,
        surfaceWater = item.surface.toIntOrZero(),
        diameter = item.diameter.toInt(),
        planetClass = item.planetClass,
        atmosphere = item.atmosphere,
        interest = selectInterests(physInfoId = item.physInfoId)
            .executeAsList()
            .mapNotNull { (interest, coverUrl) ->
                interest?.let { Interest(it, coverUrl) }
            },
        flora = selectFlora(physInfoId = item.physInfoId)
            .executeAsList()
            .mapNotNull { it.flora },
        fauna = selectFauna(physInfoId = item.physInfoId)
            .executeAsList()
            .mapNotNull { it.fauna }
    )

internal fun PlanetsQueries.parseSocInfo(item: SelectBaseItems) =
    SocietalInformation(
        population = item.population,
        government = item.government,
        nativeSpecies = selectNativeSpecies(socInfoId = item.socInfoId)
            .executeAsList()
            .mapNotNull { it.nativeSpecies },
        otherSpecies = selectOtherSpecies(socInfoId = item.socInfoId)
            .executeAsList()
            .mapNotNull { it.otherSpecies },
        primaryLanguages = selectLanguages(socInfoId = item.socInfoId)
            .executeAsList()
            .mapNotNull { it.language },
        majorCities = selectCities(socInfoId = item.socInfoId)
            .executeAsList()
            .mapNotNull { it.city }
    )

internal fun PlanetsQueries.insertAstroInfo(info: AstrographicalInformation): Long {
    insertAstroInfo(
        rotationPeriod = info.rotationPeriod.toLong(),
        orbitalPeriod = info.orbitalPeriod.toLong(),
        sector = info.sector,
        system = info.system,
        moons = info.moons.toLong()
    )

    return insertedAstroInfo().executeAsOne()
}

internal fun PlanetsQueries.insertPhysInfo(info: PhysicalInformation): Long {
    insertPhysInfo(
        climate = info.climate,
        gravity = info.gravity,
        terrain = info.terrain,
        surfaceWater = info.surfaceWater.toString(),
        diameter = info.diameter.toLong(),
        planetClass = info.planetClass,
        atmosphere = info.atmosphere
    )

    return insertedPhysInfo().executeAsOne()
}

internal fun PlanetsQueries.insertSocInfo(info: SocietalInformation): Long {
    insertSocInfo(
        population = info.population.toLong(),
        government = info.government
    )

    return insertedPhysInfo().executeAsOne()
}

internal fun PlanetsQueries.insertPlanet(
    planet: WookiepediaPlanet,
    astroInfoId: Long,
    physInfoId: Long,
    socInfoId: Long,
) = insertPlanet(
    title = planet.title,
    edited = planet.edited,
    pageNumber = planet.pageNumber.toLong(),
    description = planet.description,
    coverUrl = planet.coverUrl,
    astroInfoId = astroInfoId,
    physInfoId = physInfoId,
    socInfoId = socInfoId
)

internal fun PlanetsQueries.addPlanet(planet: WookiepediaPlanet) = runCatching {
    transaction {
        val astroInfoId = insertAstroInfo(planet.astrographicalInformation)

        planet.astrographicalInformation.region.forEach {
            insertRegion(it)
            insertAstroInfoRegion(astroInfoId, it)
        }

        planet.astrographicalInformation.tradeRoutes.forEach {
            insertTradeRoute(it)
            insertAstroInfoTradeRoute(astroInfoId, it)
        }

        val physInfoId = insertPhysInfo(planet.physicalInformation)

        planet.physicalInformation.interest.forEach {
            insertInterest(it.value, it.coverUrl)
            insertPhysInfoInterest(physInfoId = physInfoId, interest = it.value)
        }

        planet.physicalInformation.flora.forEach {
            insertFlora(it)
            insertFlora(it)
        }

        planet.physicalInformation.fauna.forEach {
            insertFauna(it)
            insertFauna(it)
        }

        val socInfoId = insertSocInfo(planet.societalInformation)

        planet.societalInformation.nativeSpecies.forEach {
            insertNativeSpecies(it)
            insertSocInfoNativeSpecied(socInfoId, it)
        }

        planet.societalInformation.otherSpecies.forEach {
            insertOtherSpecies(it)
            insertSocInfoOtherSpecies(socInfoId, it)
        }

        planet.societalInformation.primaryLanguages.forEach {
            insertLanguage(it)
            insertSocInfoLanguage(socInfoId, it)
        }

        planet.societalInformation.majorCities.forEach {
            insertCity(it)
            insertSocInfoCity(socInfoId, it)
        }

        insertPlanet(
            planet = planet,
            astroInfoId = astroInfoId,
            physInfoId = physInfoId,
            socInfoId = socInfoId
        )
    }
}
