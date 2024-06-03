package com.paranid5.star_wars_travel.data.paging

import androidx.paging.PagingSource
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet

abstract class PlanetsPagingSource : PagingSource<Int, WookiepediaPlanet>()