package com.paranid5.star_wars_travel.core.component

import kotlinx.serialization.json.Json

internal val json = Json {
    allowStructuredMapKeys = true
    ignoreUnknownKeys = true
}