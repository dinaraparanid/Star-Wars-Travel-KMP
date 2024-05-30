package com.paranid5.star_wars_travel.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(init: KoinApplication.() -> Unit = {}): KoinApplication = startKoin {
    init()
    modules(appModule)
}