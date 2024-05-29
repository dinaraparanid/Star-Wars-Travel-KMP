package com.paranid5.star_wars_travel.domain.entities

import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet

data class PlanetPage(
    val next: String?,
    val previous: String?,
    val planets: List<WookiepediaPlanet>
)