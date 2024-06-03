package com.paranid5.star_wars_travel.data.paging

import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet

internal fun List<WookiepediaPlanet>.pagesSet() =
    map(WookiepediaPlanet::pageNumber).toSet()