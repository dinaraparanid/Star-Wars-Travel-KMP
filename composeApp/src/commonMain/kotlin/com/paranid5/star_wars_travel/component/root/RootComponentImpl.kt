package com.paranid5.star_wars_travel.component.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent

class RootComponentImpl(
    componentContext: ComponentContext,
    private val planetsComponentFactory: PlanetsComponent.Factory,
    private val settingsComponentFactory: SettingsComponent.Factory,
    private val aboutAppComponentFactory: AboutAppComponent.Factory,
) : RootComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<RootConfig>()

    override val stack: Value<ChildStack<RootConfig, RootChild>> = childStack(
        source = navigation,
        serializer = RootConfig.serializer(),
        initialConfiguration = RootConfig.Planets,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(config: RootConfig, componentContext: ComponentContext) =
        when (config) {
            RootConfig.Planets -> RootChild.Planets(
                planetsComponentFactory.create(componentContext)
            )

            RootConfig.AboutApp -> RootChild.AboutApp(
                aboutAppComponentFactory.create(componentContext)
            )

            RootConfig.Settings -> RootChild.Settings(
                settingsComponentFactory.create(componentContext)
            )
        }

    override fun onUiIntent(intent: RootUiIntent) = when (intent) {
        RootUiIntent.ShowAboutApp -> navigateToAboutApp()
        RootUiIntent.ShowPlanets -> navigateToPlanets()
        RootUiIntent.ShowSettings -> navigateToSettings()
    }

    private fun navigateToPlanets() = navigation.bringToFront(RootConfig.Planets)

    private fun navigateToSettings() = navigation.bringToFront(RootConfig.Settings)

    private fun navigateToAboutApp() = navigation.bringToFront(RootConfig.AboutApp)

    class Factory(
        private val planetsComponentFactory: PlanetsComponent.Factory,
        private val settingsComponentFactory: SettingsComponent.Factory,
        private val aboutAppComponentFactory: AboutAppComponent.Factory,
    ) : RootComponent.Factory {
        override fun create(componentContext: ComponentContext): RootComponent =
            RootComponentImpl(
                componentContext = componentContext,
                planetsComponentFactory = planetsComponentFactory,
                settingsComponentFactory = settingsComponentFactory,
                aboutAppComponentFactory = aboutAppComponentFactory,
            )
    }
}