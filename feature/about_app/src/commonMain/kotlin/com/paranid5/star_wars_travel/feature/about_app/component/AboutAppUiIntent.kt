package com.paranid5.star_wars_travel.feature.about_app.component

sealed interface AboutAppUiIntent {
    data object OpenMyGitHub : AboutAppUiIntent
    data object OpenProjectGitHub : AboutAppUiIntent
}