package com.paranid5.star_wars_travel

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.paranid5.star_wars_travel.App
import com.paranid5.star_wars_travel.di.initKoin

fun main() {
    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Star Wars Travel",
        ) {
            App()
        }
    }
}