package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
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

private val WINDOW_WIDTH = 1280.dp
private val WINDOW_HEIGHT = 720.dp

fun main() {
    SwingUtilities.invokeAndWait { setMainThreadId(Thread.currentThread().id) }

    val kodein = initKodein()
    val rootComponentFactory: RootComponent.Factory by kodein.instance()
    val rootComponent = runOnUiThread {
        rootComponentFactory.create(
            DefaultComponentContext(
                lifecycle = LifecycleRegistry(),
            )
        )
    }

    application {
        Window(
            title = stringResource(Res.string.app_name),
            icon = painterResource("app_icon/app-icon.icns"),
            state = WindowState(width = WINDOW_WIDTH, height = WINDOW_HEIGHT),
            onCloseRequest = ::exitApplication,
        ) {
            App(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}