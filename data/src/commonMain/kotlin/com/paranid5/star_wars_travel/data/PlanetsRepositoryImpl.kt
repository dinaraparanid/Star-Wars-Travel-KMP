package com.paranid5.star_wars_travel.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.paranid5.star_wars_travel.data.PlanetsRepository.Companion.PAGE_SIZE
import com.paranid5.star_wars_travel.data.ktor.PlanetsNetSource
import com.paranid5.star_wars_travel.data.paging.PlanetsPagingSourceImpl
import com.paranid5.star_wars_travel.data.sqldelight.PlanetsDbSource
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest

internal class PlanetsRepositoryImpl(
    private val netSource: PlanetsNetSource,
    private val dbSource: PlanetsDbSource,
) : PlanetsRepository {
    override val planetsPagedFlow
        get() = Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PAGE_SIZE / 2),
            pagingSourceFactory = { PlanetsPagingSourceImpl(netSource, dbSource) }
        ).flow

    override fun updateInterestsAsync(interests: List<Interest>) =
        dbSource.updateInterestsAsync(interests)
}