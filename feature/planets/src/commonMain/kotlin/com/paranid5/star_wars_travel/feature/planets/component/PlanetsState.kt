package com.paranid5.star_wars_travel.feature.planets.component

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class PlanetsState(
    val searchText: String,
    val selectedRegions: ImmutableList<String?>,
) {
    internal companion object {
        inline val default
            get() = PlanetsState(
                searchText = "",
                selectedRegions = persistentListOf()
            )
    }
}
