package com.paranid5.star_wars_travel.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(): KoinApplication = startKoin {
    modules(themeModule)
}