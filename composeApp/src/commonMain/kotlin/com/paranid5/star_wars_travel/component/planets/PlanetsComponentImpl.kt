package com.paranid5.star_wars_travel.component.planets

import com.arkivanov.decompose.ComponentContext

class PlanetsComponentImpl(componentContext: ComponentContext) :
    PlanetsComponent,
    ComponentContext by componentContext {
    class Factory : PlanetsComponent.Factory {
        override fun create(componentContext: ComponentContext): PlanetsComponent =
            PlanetsComponentImpl(componentContext)
    }
}
