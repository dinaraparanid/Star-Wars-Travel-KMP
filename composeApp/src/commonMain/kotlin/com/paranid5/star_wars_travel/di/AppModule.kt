package com.paranid5.star_wars_travel.di

import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.component.root.RootComponentImpl
import com.paranid5.star_wars_travel.core.common.di.themeModule
import com.paranid5.star_wars_travel.feature.about_app.di.aboutAppModule
import com.paranid5.star_wars_travel.feature.planets.di.planetsModule
import com.paranid5.star_wars_travel.feature.settings.di.settingsModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    includes(themeModule, aboutAppModule, planetsModule, settingsModule)
    singleOf(RootComponentImpl::Factory) bind RootComponent.Factory::class
}