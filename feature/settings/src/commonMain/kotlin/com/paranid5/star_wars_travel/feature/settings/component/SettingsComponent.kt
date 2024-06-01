package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext

interface SettingsComponent : ComponentContext {
    interface Factory {
        fun create(componentContext: ComponentContext): SettingsComponent
    }
}