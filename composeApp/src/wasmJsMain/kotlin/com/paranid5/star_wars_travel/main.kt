package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.di.initKodein
import com.paranid5.star_wars_travel.presentation.App
import kotlinx.browser.document
import org.kodein.di.instance

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val kodein = initKodein()
    val rootComponentFactory: RootComponent.Factory by kodein.instance()
    val rootComponent = rootComponentFactory.create(DefaultComponentContext(LifecycleRegistry()))
    ComposeViewport(document.body ?: return) {
        App(
            rootComponent = rootComponent,
            modifier = Modifier.fillMaxSize(),
        )
    }
}