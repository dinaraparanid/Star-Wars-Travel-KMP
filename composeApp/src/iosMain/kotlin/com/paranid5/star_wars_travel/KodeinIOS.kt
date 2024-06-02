package com.paranid5.star_wars_travel

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProvider
import com.paranid5.star_wars_travel.di.initKodein
import org.kodein.di.instance

data class MainViewControllerArgs(
    val rootComponent: RootComponent,
    val themeProvider: ThemeProvider,
)

object KodeinIOS {
    fun initializeWithControllerArgs(): MainViewControllerArgs {
        val kodein = initKodein()
        val rootComponentFactory: RootComponent.Factory by kodein.instance()
        val themeProvider: ThemeProvider by kodein.instance()
        val rootComponent = rootComponentFactory.create(DefaultComponentContext(ApplicationLifecycle()))
        return MainViewControllerArgs(
            rootComponent = rootComponent,
            themeProvider = themeProvider,
        )
    }
}