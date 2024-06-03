package com.paranid5.star_wars_travel.data.ktor.wookiepedia

import com.fleeksoft.ksoup.nodes.Element

internal fun Element.info(selector: String) =
    runCatching {
        select("div[data-source=$selector]")
            .firstOrNull()
            ?.children()
            ?.firstOrNull { it.tagName() == "div" }
            ?.children()
            ?.flatMap { elem ->
                elem
                    .select("a,p")
                    .map { it.text().replace(CITATION_REGEX, "") }
                    .filter(String::isNotBlank)
            }
            .orEmpty()
    }.getOrElse { emptyList() }