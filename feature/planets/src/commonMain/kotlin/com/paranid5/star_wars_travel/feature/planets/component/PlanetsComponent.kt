package com.paranid5.star_wars_travel.feature.planets.component

import com.arkivanov.decompose.ComponentContext

interface PlanetsComponent : ComponentContext {
    interface Factory {
        fun create(componentContext: ComponentContext): PlanetsComponent
    }
}