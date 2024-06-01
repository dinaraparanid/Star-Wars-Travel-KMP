package com.paranid5.star_wars_travel.feature.planet.component

import com.arkivanov.decompose.ComponentContext

internal class PlanetComponentImpl(componentContext: ComponentContext) :
    PlanetComponent,
    ComponentContext by componentContext {
    class Factory : PlanetComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetComponent =
            PlanetComponentImpl(componentContext)
    }
}
