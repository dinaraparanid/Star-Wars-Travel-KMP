package com.paranid5.star_wars_travel.feature.planet.di

import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponentImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val planetModule = module {
    singleOf(PlanetComponentImpl::Factory) bind PlanetComponent.Factory::class
}