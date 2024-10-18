package com.paranid5.star_wars_travel.domain.planets

import androidx.paging.PagingData
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface PlanetsRepository {
    val planetsPagedFlow: Flow<PagingData<WookiepediaPlanet>>
    fun updateInterestsAsync(interests: List<Interest>): Job
}