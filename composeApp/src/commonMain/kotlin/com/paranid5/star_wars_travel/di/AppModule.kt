package com.paranid5.star_wars_travel.di

import org.koin.dsl.module

val appModule = module {
    includes(themeModule)
}