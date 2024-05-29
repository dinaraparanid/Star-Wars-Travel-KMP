package com.paranid5.star_wars_travel

import androidx.compose.ui.window.ComposeUIViewController
import com.paranid5.star_wars_travel.di.initKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    initKoin()
    return ComposeUIViewController { App() }
}