package com.paranid5.star_wars_travel.component.root

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootConfig {

    @Serializable
    data object Planets : RootConfig

    @Serializable
    data object Settings : RootConfig

    @Serializable
    data object AboutApp : RootConfig
}
