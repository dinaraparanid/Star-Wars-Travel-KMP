package com.paranid5.star_wars_travel.feature.planets.component

sealed interface PlanetsUiIntent {
    data class UpdateSearchText(val text: String) : PlanetsUiIntent
    data class ReselectRegion(val region: String?) : PlanetsUiIntent
}