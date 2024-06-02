package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.data.StorageRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton

actual val dataModule = DI.Module("dataModule") {
    import(themeModule)
    bind<StorageRepository>() with multiton { StorageRepositoryImpl(di) }
}