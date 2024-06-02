package com.paranid5.star_wars_travel.domain.entities.wookiepedia

import kotlinx.serialization.Serializable

@Serializable
data class Interest(
    val value: String,
    val coverUrl: String?
)