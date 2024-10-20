package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.mvikotlin.core.utils.setMainThreadId
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_name
import com.paranid5.star_wars_travel.di.initKodein
import com.paranid5.star_wars_travel.presentation.App
import org.jetbrains.compose.resources.stringResource
import org.kodein.di.instance
import javax.swing.SwingUtilities

private val DefaultWidth = 1280.dp
private val DefaultHeight = 720.dp

fun main() {
    SwingUtilities.invokeAndWait { setMainThreadId(Thread.currentThread().threadId()) }

    val kodein = initKodein()
    val rootComponentFactory: RootComponent.Factory by kodein.instance()
    val lifecycle = LifecycleRegistry()
    val rootComponent = runOnUiThread {
        rootComponentFactory.create(DefaultComponentContext(lifecycle))
    }

    application {
        val windowState = rememberWindowState(
            size = DpSize(width = DefaultWidth, height = DefaultHeight)
        )

        LifecycleController(
            lifecycleRegistry = lifecycle,
            windowState = windowState,
        )

        Window(
            title = stringResource(Res.string.app_name),
            state = windowState,
            onCloseRequest = ::exitApplication,
        ) {
            App(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
