package com.paranid5.star_wars_travel.core.common.utils

import com.paranid5.star_wars_travel.core.common.domain.use_case.OpenBrowserUseCase
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal class OpenBrowserUseCaseImpl : OpenBrowserUseCase {
    override fun openBrowser(url: String): Boolean =
        UIApplication.sharedApplication.openURL(NSURL(string = url))
}