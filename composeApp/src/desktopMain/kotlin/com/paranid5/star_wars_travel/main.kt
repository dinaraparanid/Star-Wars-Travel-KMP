package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.component.readSerializableContainer
import com.paranid5.star_wars_travel.di.initKoin
import com.paranid5.star_wars_travel.presentation.App
import java.io.File

private const val SAVED_STATE_FILE_NAME = "saved_state.dat"

fun main() {
    val koin = initKoin().koin
    val rootComponentFactory = koin.get<RootComponent.Factory>()

    val lifecycle = LifecycleRegistry()
    val stateKeeper = StateKeeperDispatcher(File(SAVED_STATE_FILE_NAME).readSerializableContainer())

    val rootComponent = rootComponentFactory.create(
        DefaultComponentContext(
            lifecycle = lifecycle,
            stateKeeper = stateKeeper,
        )
    )

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Star Wars Travel",
        ) {
            App(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}