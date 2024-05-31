package com.paranid5.star_wars_travel.core.common.domain.entities.wookiepedia

import kotlinx.serialization.Serializable

@Serializable
data class PhysicalInformation(
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: Int,
    val diameter: Int = 0,
    val planetClass: String? = null,
    val atmosphere: String? = null,
    val interest: List<Interest> = emptyList(),
    val flora: List<String> = emptyList(),
    val fauna: List<String> = emptyList()
)