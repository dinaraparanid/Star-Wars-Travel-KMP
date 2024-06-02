package com.paranid5.star_wars_travel.core.common.di

import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProvider
import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider.ThemeProviderImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val themeModule = DI.Module("themeModule") {
    bind<ThemeProvider>() with singleton { new(::ThemeProviderImpl) }
}