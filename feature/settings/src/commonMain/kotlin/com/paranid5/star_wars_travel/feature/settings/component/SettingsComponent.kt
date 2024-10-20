package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.core.component.UiIntentHandler

interface SettingsComponent :
    ComponentContext,
    StateSource<SettingsState>,
    UiIntentHandler<SettingsUiIntent> {

    interface Factory {
        fun create(componentContext: ComponentContext): SettingsComponent
    }
}
