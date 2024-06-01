package com.paranid5.star_wars_travel.core.common.utils

import java.awt.Desktop
import java.net.URI

actual fun openBrowser(url: String): Boolean =
    openWebpage(URI.create(url))

private fun openWebpage(uri: URI): Boolean {
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