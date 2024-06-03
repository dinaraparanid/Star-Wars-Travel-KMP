package com.paranid5.star_wars_travel.data.sqldelight

import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

internal interface PlanetsDbSource {
    val planetsFlow: Flow<List<WookiepediaPlanet>>

    suspend fun getPlanets(): List<WookiepediaPlanet>

    fun addPlanetAsync(planet: WookiepediaPlanet): Job

    fun updateInterestsAsync(interests: List<Interest>): Job
}