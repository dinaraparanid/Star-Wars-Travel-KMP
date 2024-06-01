package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_icon
import com.paranid5.star_wars_travel.core.resources.app_name
import com.paranid5.star_wars_travel.di.initKoin
import com.paranid5.star_wars_travel.presentation.App
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

fun main() {
    val koin = initKoin().koin
    val rootComponentFactory = koin.get<RootComponent.Factory>()

    val rootComponent = runOnUiThread {
        rootComponentFactory.create(
            DefaultComponentContext(
                lifecycle = LifecycleRegistry(),
            )
        )
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = stringResource(Res.string.app_name),
            icon = painterResource(Res.drawable.app_icon),
        ) {
            App(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}