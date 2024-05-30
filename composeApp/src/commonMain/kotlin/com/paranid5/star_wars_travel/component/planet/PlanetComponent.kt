package com.paranid5.star_wars_travel.component.planet

import com.arkivanov.decompose.ComponentContext

interface PlanetComponent : ComponentContext {
    interface Factory {
        fun create(componentContext: ComponentContext): PlanetComponent
    }
}