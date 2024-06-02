package com.paranid5.star_wars_travel

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.di.initKodein
import org.kodein.di.instance

data class MainViewControllerArgs(
    val rootComponent: RootComponent,
    val storageRepository: StorageRepository,
)

object KodeinIOS {
    fun initializeWithControllerArgs(): MainViewControllerArgs {
        val kodein = initKodein()
        val rootComponentFactory: RootComponent.Factory by kodein.instance()
        val storageRepository: StorageRepository by kodein.instance()
        val rootComponent = rootComponentFactory.create(DefaultComponentContext(ApplicationLifecycle()))
        return MainViewControllerArgs(
            rootComponent = rootComponent,
            storageRepository = storageRepository,
        )
    }
}