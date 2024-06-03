package com.paranid5.star_wars_travel.data.ktor.wookiepedia

private const val PLACEHOLDER_URL = "https://static.wikia.nocookie.net/starwars/images/e/e6/Site-logo.png/revision/latest?cb=20240202041003"

internal suspend inline fun loadInterestCover(interest: String) =
    WookieHtml(interest)
        .getOrNull()
        ?.urlCover()
        ?.map { if (it == PLACEHOLDER_URL) null else it }
        ?.getOrNull()