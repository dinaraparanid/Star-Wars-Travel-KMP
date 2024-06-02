package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.UiIntentHandler
import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.coroutines.flow.Flow

interface SettingsComponent : ComponentContext, UiIntentHandler<SettingsUiIntent> {
    val themeFlow: Flow<Theme>

    interface Factory {
        fun create(componentContext: ComponentContext): SettingsComponent
    }
}