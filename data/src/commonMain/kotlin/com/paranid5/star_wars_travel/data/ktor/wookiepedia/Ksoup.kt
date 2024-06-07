package com.paranid5.star_wars_travel.data.ktor.wookiepedia

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequest
import com.fleeksoft.ksoup.nodes.Element
import com.fleeksoft.ksoup.parser.Parser
import com.paranid5.star_wars_travel.data.DataDispatcher
import com.paranid5.star_wars_travel.data.ktor.USER_AGENT
import com.paranid5.star_wars_travel.domain.entities.SwapiPlanet
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.WookiepediaPlanet
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.userAgent
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

private const val WOOKIEPEDIA_BASE_URL = "https://starwars.fandom.com/wiki"

internal val CITATION_REGEX = Regex("\\[\\d+]")

private const val FETCH_TIMEOUT_MS = 10_000L

internal suspend fun PlanetDTO(planet: SwapiPlanet, pageNumber: Int) = coroutineScope {
    val html = WookieHtml(planet.name).getOrNull()
    val shortDescription = html?.shortDescription()?.getOrNull()

    WookiepediaPlanet(
        title = planet.name,
        edited = planet.edited,
        pageNumber = pageNumber,
        description = html?.planetDescription()?.getOrNull(),
        coverUrl = html?.urlCover()?.getOrNull(),
        astrographicalInformation = shortDescription
            ?.astrographicalInfo(planet)
            ?: defaultAstroInfo(planet),
        physicalInformation = shortDescription
            ?.physicalInfo(planet)
            ?: defaultPhysInfo(planet),
        societalInformation = shortDescription
            ?.societalInfo(planet)
            ?: defaultSocInfo(planet)
    )
}

internal suspend inline fun WookieHtml(query: String) = runCatching {
    withTimeout(FETCH_TIMEOUT_MS) {
        Ksoup.parseGetRequest(
            url = "$WOOKIEPEDIA_BASE_URL/${wookiepediaFormat(query)}",
            httpRequestBuilder = {
                accept(ContentType.Any)
                userAgent(USER_AGENT)
            },
            parser = Parser.xmlParser()
        )
    }
}

private suspend inline fun Element.planetDescription() = runCatching {
    withContext(DataDispatcher) {
        select("div[class=mw-parser-output]")
            .firstOrNull()
            ?.children()
            ?.filterNot { it.tagName() != "p" }
            ?.drop(1)
            ?.firstOrNull()
            ?.text()
            ?.replace(CITATION_REGEX, "")
    }
}

private suspend inline fun Element.shortDescription() = runCatching {
    withContext(DataDispatcher) {
        select("aside[role=region]").firstOrNull()
    }
}

internal suspend inline fun Element.urlCover() = runCatching {
    withContext(DataDispatcher) {
        select("meta[property=og:image]")
            .attr("content")
    }
}

private fun wookiepediaFormat(planet: String) =
    planet.replace(" ", "_")