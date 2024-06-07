package com.paranid5.star_wars_travel

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.di.initKodein
import org.kodein.di.instance

object KodeinIOS {
    fun initializeWithRootComponent(): RootComponent {
        val kodein = initKodein()
        val rootComponentFactory: RootComponent.Factory by kodein.instance()
        return rootComponentFactory.create(DefaultComponentContext(ApplicationLifecycle()))
    }
}