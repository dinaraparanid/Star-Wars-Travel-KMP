package com.paranid5.star_wars_travel.data.ktor.wookiepedia

private const val PLACEHOLDER_URL = "https://static.wikia.nocookie.net/starwars/images/e/e6/Site-logo.png/revision/latest?cb=20240202041003"

suspend fun loadInterestCover(interest: String) =
    WookieHtml(interest)
        .getOrNull()
        ?.urlCover()
        ?.map { url -> url.takeIf { it != PLACEHOLDER_URL } }
        ?.getOrNull()