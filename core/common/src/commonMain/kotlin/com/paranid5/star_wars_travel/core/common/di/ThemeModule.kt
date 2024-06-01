package com.paranid5.star_wars_travel.core.common.di

import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProvider
import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val themeModule = module {
    singleOf(::ThemeProviderImpl) bind ThemeProvider::class
}