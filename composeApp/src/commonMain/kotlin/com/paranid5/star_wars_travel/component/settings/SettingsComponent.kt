package com.paranid5.star_wars_travel.component.settings

import com.arkivanov.decompose.ComponentContext

interface SettingsComponent : ComponentContext {
    interface Factory {
        fun create(componentContext: ComponentContext): SettingsComponent
    }
}