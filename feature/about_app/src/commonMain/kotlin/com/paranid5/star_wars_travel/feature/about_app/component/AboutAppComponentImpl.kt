package com.paranid5.star_wars_travel.feature.about_app.component

import com.arkivanov.decompose.ComponentContext

internal class AboutAppComponentImpl(componentContext: ComponentContext) :
    AboutAppComponent,
    ComponentContext by componentContext {
    class Factory : AboutAppComponent.Factory {
        override fun create(context: ComponentContext): AboutAppComponent =
            AboutAppComponentImpl(context)
    }
}
