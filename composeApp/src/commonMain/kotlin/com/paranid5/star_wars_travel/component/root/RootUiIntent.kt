package com.paranid5.star_wars_travel.component.root

sealed interface RootUiIntent {
    data object ShowPlanets : RootUiIntent
    data object ShowSettings : RootUiIntent
    data object ShowAboutApp : RootUiIntent
}
