package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.ktor.KtorClient
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val ktorClientModule = DI.Module("ktorClientModule") {
    bind<Json>() with singleton { Json { ignoreUnknownKeys = true } }

    bind<HttpClient>() with singleton {
        val json by di.instance<Json>()
        KtorClient(json = json)
    }
}
