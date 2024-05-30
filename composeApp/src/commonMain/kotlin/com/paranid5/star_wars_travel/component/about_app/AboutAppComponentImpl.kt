package com.paranid5.star_wars_travel.component.about_app

import com.arkivanov.decompose.ComponentContext

class AboutAppComponentImpl(componentContext: ComponentContext) :
    AboutAppComponent,
    ComponentContext by componentContext {
    class Factory : AboutAppComponent.Factory {
        override fun create(context: ComponentContext): AboutAppComponent =
            AboutAppComponentImpl(context)
    }
}
