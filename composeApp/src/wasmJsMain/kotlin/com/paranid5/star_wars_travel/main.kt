package com.paranid5.star_wars_travel

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.paranid5.star_wars_travel.di.initKoin
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()

    ComposeViewport(document.body!!) { App() }
}