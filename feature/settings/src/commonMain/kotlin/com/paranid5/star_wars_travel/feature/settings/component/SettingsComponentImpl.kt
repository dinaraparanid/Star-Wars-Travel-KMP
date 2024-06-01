package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext

internal class SettingsComponentImpl(componentContext: ComponentContext) :
    SettingsComponent,
    ComponentContext by componentContext {
    class Factory : SettingsComponent.Factory {
        override fun create(componentContext: ComponentContext): SettingsComponent =
            SettingsComponentImpl(componentContext)
    }
}
