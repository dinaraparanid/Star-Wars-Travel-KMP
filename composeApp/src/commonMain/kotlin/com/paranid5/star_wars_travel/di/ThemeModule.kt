package com.paranid5.star_wars_travel.di

import com.paranid5.star_wars_travel.presentation.ThemeProvider
import com.paranid5.star_wars_travel.presentation.ThemeProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val themeModule = module {
    singleOf(::ThemeProviderImpl) bind ThemeProvider::class
}