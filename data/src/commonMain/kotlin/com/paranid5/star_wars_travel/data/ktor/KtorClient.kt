package com.paranid5.star_wars_travel.data.ktor

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

internal const val USER_AGENT =
    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.98 Safari/537.36"

internal expect fun KtorClient(json: Json): HttpClient