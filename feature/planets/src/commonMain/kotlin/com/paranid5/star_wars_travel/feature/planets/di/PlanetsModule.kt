package com.paranid5.star_wars_travel.feature.planets.di

import com.paranid5.star_wars_travel.feature.planet.di.planetModule
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponentImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val planetsModule = DI.Module("planetsModule") {
    import(planetModule)
    bind<PlanetsComponent.Factory>() with singleton { new(PlanetsComponentImpl::Factory) }
}