package com.paranid5.star_wars_travel.data.ktor.swapi

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val SWAPI_BASE_URL = "https://swapi.dev/api"

internal suspend fun HttpClient.getSwapiPlanets(page: Int) =
    runCatching { get("$SWAPI_BASE_URL/planets/?page=$page").body<SwapiPlanetPage>() }