package com.paranid5.star_wars_travel.data.planets

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.paranid5.star_wars_travel.data.ktor.PlanetsNetSource
import com.paranid5.star_wars_travel.data.paging.PlanetsPagingSourceImpl
import com.paranid5.star_wars_travel.data.sqldelight.PlanetsDbSource
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import com.paranid5.star_wars_travel.domain.planets.PlanetsRepository

internal class PlanetsRepositoryImpl(
    private val netSource: PlanetsNetSource,
    private val dbSource: PlanetsDbSource,
) : PlanetsRepository {
    private companion object {
        const val PAGE_SIZE = 10
    }

    override val planetsPagedFlow by lazy {
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PAGE_SIZE / 2),
            pagingSourceFactory = { PlanetsPagingSourceImpl(netSource, dbSource) }
        ).flow
    }

    override fun updateInterestsAsync(interests: List<Interest>) =
        dbSource.updateInterestsAsync(interests)
}
