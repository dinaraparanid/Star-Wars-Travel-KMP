package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.sqldelight.PlanetsDbSource
import com.paranid5.star_wars_travel.data.sqldelight.PlanetsDbSourceImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

internal val planetsDbModule = DI.Module("planetsDbModule") {
    bind<PlanetsDbSource>() with multiton { new(::PlanetsDbSourceImpl) }
}