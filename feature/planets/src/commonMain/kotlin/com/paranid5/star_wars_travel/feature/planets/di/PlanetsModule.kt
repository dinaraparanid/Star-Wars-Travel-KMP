package com.paranid5.star_wars_travel.feature.planets.di

import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponentImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val planetsModule = module {
    singleOf(PlanetsComponentImpl::Factory) bind PlanetsComponent.Factory::class
}