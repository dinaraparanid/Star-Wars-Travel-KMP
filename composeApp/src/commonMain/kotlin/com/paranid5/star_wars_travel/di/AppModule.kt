package com.paranid5.star_wars_travel.di

import com.paranid5.star_wars_travel.core.common.di.themeModule
import org.koin.dsl.module

val appModule = module {
    includes(themeModule)
}