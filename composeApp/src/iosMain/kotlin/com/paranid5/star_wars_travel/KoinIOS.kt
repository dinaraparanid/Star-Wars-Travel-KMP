package com.paranid5.star_wars_travel

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.di.initKoin

object KoinIOS {
    fun initializeWithRootComponent(): RootComponent {
        val koin = initKoin().koin
        val rootComponentFactory = koin.get<RootComponent.Factory>()
        return rootComponentFactory.create(DefaultComponentContext(ApplicationLifecycle()))
    }
}