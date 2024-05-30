package com.paranid5.star_wars_travel.component.planet

import com.arkivanov.decompose.ComponentContext

class PlanetComponentImpl(componentContext: ComponentContext) :
    PlanetComponent,
    ComponentContext by componentContext {
    class Factory : PlanetComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetComponent =
            PlanetComponentImpl(componentContext)
    }
}
