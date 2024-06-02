package com.paranid5.star_wars_travel.di

import org.kodein.di.DI

fun initKodein(init: DI.MainBuilder.() -> Unit = {}) = DI {
    init()
    import(appModule)
}