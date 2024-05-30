package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.paranid5.star_wars_travel.di.initKoin
import com.paranid5.star_wars_travel.presentation.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    initKoin()
    return ComposeUIViewController { App(Modifier.fillMaxSize()) }
}