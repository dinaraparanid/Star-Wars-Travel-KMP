package com.paranid5.star_wars_travel.component.settings

import com.arkivanov.decompose.ComponentContext

class SettingsComponentImpl(componentContext: ComponentContext) :
    SettingsComponent,
    ComponentContext by componentContext {
    class Factory : SettingsComponent.Factory {
        override fun create(componentContext: ComponentContext): SettingsComponent =
            SettingsComponentImpl(componentContext)
    }
}
