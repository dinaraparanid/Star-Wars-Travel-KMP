package com.paranid5.star_wars_travel.di

import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.component.root.RootComponentImpl
import com.paranid5.star_wars_travel.core.common.di.openBrowserModule
import com.paranid5.star_wars_travel.core.common.di.themeModule
import com.paranid5.star_wars_travel.feature.about_app.di.aboutAppModule
import com.paranid5.star_wars_travel.feature.planets.di.planetsModule
import com.paranid5.star_wars_travel.feature.settings.di.settingsModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

val appModule = DI.Module("appModule") {
    importAll(
        themeModule,
        openBrowserModule,
        aboutAppModule,
        planetsModule,
        settingsModule,
    )

    bind<RootComponent.Factory>() with multiton { new(RootComponentImpl::Factory) }
}