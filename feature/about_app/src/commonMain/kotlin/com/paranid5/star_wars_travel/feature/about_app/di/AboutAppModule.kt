package com.paranid5.star_wars_travel.feature.about_app.di

import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponentImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val aboutAppModule = module {
    singleOf(AboutAppComponentImpl::Factory) bind AboutAppComponent.Factory::class
}