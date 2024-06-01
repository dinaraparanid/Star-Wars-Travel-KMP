package com.paranid5.star_wars_travel.feature.about_app.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.UiIntentHandler

interface AboutAppComponent : ComponentContext, UiIntentHandler<AboutAppUiIntent> {
    interface Factory {
        fun create(context: ComponentContext): AboutAppComponent
    }
}