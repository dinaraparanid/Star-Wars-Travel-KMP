package com.paranid5.star_wars_travel.feature.planet.di

import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponentImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.new
import org.kodein.di.singleton

val planetModule: DI.Module = DI.Module("planetModule") {
    bind<PlanetComponent.Factory>() with singleton { new(PlanetComponentImpl::Factory) }
}
