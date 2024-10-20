package com.paranid5.star_wars_travel.component.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.essenty.lifecycle.doOnStart
import com.arkivanov.essenty.lifecycle.doOnStop
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.core.component.getComponentState
import com.paranid5.star_wars_travel.domain.theme.ThemeRepository
import com.paranid5.star_wars_travel.domain.utils.updateState
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent
import com.paranid5.star_wars_travel.feature.settings.component.SettingsComponent
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class RootComponentImpl(
    componentContext: ComponentContext,
    private val planetsComponentFactory: PlanetsComponent.Factory,
    private val settingsComponentFactory: SettingsComponent.Factory,
    private val aboutAppComponentFactory: AboutAppComponent.Factory,
    themeRepository: ThemeRepository,
) : RootComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<RootConfig>()

    private var themeJob: Job? = null

    private val componentState = getComponentState(RootState())

    private val _stateFlow = MutableStateFlow(componentState.value)
    override val stateFlow = _stateFlow.asStateFlow()

    override val stack = childStack(
        source = navigation,
        serializer = RootConfig.serializer(),
        initialConfiguration = RootConfig.Planets,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    init {
        doOnStart {
            themeJob = componentScope.launch {
                themeRepository.themeFlow.collectLatest { theme ->
                    _stateFlow.updateState { copy(theme = theme) }
                }
            }
        }

        doOnStop { themeJob?.cancel() }
    }

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

    override fun onUiIntent(intent: RootUiIntent): Unit = when (intent) {
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
        private val themeRepository: ThemeRepository,
    ) : RootComponent.Factory {
        override fun create(componentContext: ComponentContext): RootComponent =
            RootComponentImpl(
                componentContext = componentContext,
                planetsComponentFactory = planetsComponentFactory,
                settingsComponentFactory = settingsComponentFactory,
                aboutAppComponentFactory = aboutAppComponentFactory,
                themeRepository = themeRepository,
            )
    }
}
