package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.data.StorageRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

actual val dataModule = DI.Module("dataModule") {
    importAll(
        themeModule,
        ktorClientModule,
        planetsNetModule,
        sqlDelightClientModule,
        planetsDbModule,
        planetsRepositoryModule,
    )

    bind<StorageRepository>() with singleton { StorageRepositoryImpl(di) }
}