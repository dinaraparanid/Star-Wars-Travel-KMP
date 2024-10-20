package com.paranid5.star_wars_travel.domain

import com.paranid5.star_wars_travel.domain.use_case.OpenBrowserUseCase
import java.awt.Desktop
import java.net.URI

internal class OpenBrowserUseCaseImpl : OpenBrowserUseCase {
    override fun openBrowser(url: String): Boolean =
        openWebpage(URI.create(url))
}

internal fun openWebpage(uri: URI): Boolean {
    val desktop = when {
        Desktop.isDesktopSupported() -> Desktop.getDesktop()
        else -> return false
    }

    return desktop
        .takeIf { it.isSupported(Desktop.Action.BROWSE) }
        ?.runCatching { browse(uri) }
        ?.map { true }
        ?.getOrNull()
        ?: false
}
