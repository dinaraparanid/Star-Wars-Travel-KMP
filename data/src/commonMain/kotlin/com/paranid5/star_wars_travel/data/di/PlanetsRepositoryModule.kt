package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.PlanetsRepository
import com.paranid5.star_wars_travel.data.PlanetsRepositoryImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

internal val planetsRepositoryModule = DI.Module("planetsRepositoryModule") {
    bind<PlanetsRepository>() with multiton { new(::PlanetsRepositoryImpl) }
}