package com.paranid5.star_wars_travel.feature.settings.di

import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponentImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val settingsModule = module {
    singleOf(SettingsComponentImpl::Factory) bind SettingsComponent.Factory::class
}