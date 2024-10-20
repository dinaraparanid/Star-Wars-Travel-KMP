package com.paranid5.star_wars_travel.feature.settings.di

import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponentImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val settingsModule: DI.Module = DI.Module("settingsModule") {
    bind<SettingsComponent.Factory>() with singleton { new(SettingsComponentImpl::Factory) }
}
