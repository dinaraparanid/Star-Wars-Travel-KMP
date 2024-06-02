package com.paranid5.star_wars_travel.core.common.domain.use_case

interface OpenBrowserUseCase {
    fun openBrowser(url: String): Boolean
}