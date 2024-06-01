package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.decompose.ComponentContext

internal class PlanetsComponentImpl(componentContext: ComponentContext) :
    PlanetsComponent,
    ComponentContext by componentContext {
    class Factory : PlanetsComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetsComponent =
            PlanetsComponentImpl(componentContext)
    }
}
