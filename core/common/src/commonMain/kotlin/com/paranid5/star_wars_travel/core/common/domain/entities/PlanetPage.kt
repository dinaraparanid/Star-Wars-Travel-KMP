package com.paranid5.star_wars_travel.core.common.domain.entities

import com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia.WookiepediaPlanet

data class PlanetPage(
    val next: String?,
    val previous: String?,
    val planets: List<WookiepediaPlanet>
)