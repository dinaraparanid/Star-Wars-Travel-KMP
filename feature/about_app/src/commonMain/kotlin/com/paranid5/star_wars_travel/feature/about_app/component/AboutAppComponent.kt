package com.paranid5.star_wars_travel.feature.about_app.component

import com.arkivanov.decompose.ComponentContext

interface AboutAppComponent : ComponentContext {
    interface Factory {
        fun create(context: ComponentContext): AboutAppComponent
    }
}