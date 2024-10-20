package com.paranid5.star_wars_travel.feature.about_app.di

import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponentImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val aboutAppModule: DI.Module = DI.Module("aboutAppModule") {
    bind<AboutAppComponent.Factory>() with singleton { new(AboutAppComponentImpl::Factory) }
}