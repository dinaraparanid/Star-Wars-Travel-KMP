package com.paranid5.star_wars_travel.data.di

import org.kodein.di.DI

actual val dataModule = DI.Module("dataModule") {
    importAll(
        themeModule,
        ktorClientModule,
        planetsNetModule,
        sqlDelightClientModule,
        planetsDbModule,
        planetsRepositoryModule
    )
}