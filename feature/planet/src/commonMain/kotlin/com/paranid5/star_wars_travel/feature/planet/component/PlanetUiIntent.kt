package com.paranid5.star_wars_travel.feature.planet.component

sealed interface PlanetUiIntent {
    data object GoBack : PlanetUiIntent
    data object ChangeDescriptionVisibility : PlanetUiIntent
    data object ShowTravelSnackbar : PlanetUiIntent
    data object HideTravelSnackbar : PlanetUiIntent
}