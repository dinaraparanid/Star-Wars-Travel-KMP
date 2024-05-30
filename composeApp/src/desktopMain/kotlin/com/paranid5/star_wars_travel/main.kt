package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.paranid5.star_wars_travel.presentation.App
import com.paranid5.star_wars_travel.di.initKoin

fun main() {
    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Star Wars Travel",
        ) {
            App(Modifier.fillMaxSize())
        }
    }
}