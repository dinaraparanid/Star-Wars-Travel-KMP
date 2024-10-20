package com.paranid5.star_wars_travel.core.component.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val storeFactoryModule: DI.Module = DI.Module("storeFactoryModule") {
    bind<StoreFactory>() with singleton { new(::DefaultStoreFactory) }
}