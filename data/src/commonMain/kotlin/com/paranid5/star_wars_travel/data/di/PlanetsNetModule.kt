package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.ktor.PlanetsNetSource
import com.paranid5.star_wars_travel.data.ktor.PlanetsNetSourceImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

internal val planetsNetModule = DI.Module("planetsNetModule") {
    bind<PlanetsNetSource>() with multiton { new(::PlanetsNetSourceImpl) }
}