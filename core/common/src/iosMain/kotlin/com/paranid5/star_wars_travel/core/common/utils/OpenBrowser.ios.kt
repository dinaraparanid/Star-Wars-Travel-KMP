package com.paranid5.star_wars_travel.core.common.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openBrowser(url: String): Boolean =
    UIApplication.sharedApplication.openURL(NSURL(string = url))