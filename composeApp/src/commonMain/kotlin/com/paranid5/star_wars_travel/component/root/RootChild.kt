package com.paranid5.star_wars_travel.component.root

import com.paranid5.star_wars_travel.component.about_app.AboutAppComponent
import com.paranid5.star_wars_travel.component.planets.PlanetsComponent
import com.paranid5.star_wars_travel.component.settings.SettingsComponent

sealed interface RootChild {
    data class PlanetsChild(val component: PlanetsComponent) : RootChild
    data class SettingsChild(val component: SettingsComponent) : RootChild
    data class AboutAppChild(val component: AboutAppComponent) : RootChild
}