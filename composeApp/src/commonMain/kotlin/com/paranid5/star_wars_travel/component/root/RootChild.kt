package com.paranid5.star_wars_travel.component.root

import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent

sealed interface RootChild {
    class Planets(val component: PlanetsComponent) : RootChild
    class Settings(val component: SettingsComponent) : RootChild
    class AboutApp(val component: AboutAppComponent) : RootChild
}
