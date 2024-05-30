package com.paranid5.star_wars_travel.component.about_app

import com.arkivanov.decompose.ComponentContext

interface AboutAppComponent : ComponentContext {
    interface Factory {
        fun create(context: ComponentContext): AboutAppComponent
    }
}