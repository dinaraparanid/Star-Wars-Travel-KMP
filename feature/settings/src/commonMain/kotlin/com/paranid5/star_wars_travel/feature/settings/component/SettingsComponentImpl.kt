package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnStart
import com.arkivanov.essenty.lifecycle.doOnStop
import com.paranid5.star_wars_travel.core.component.StatePublisher
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.core.component.getComponentState
import com.paranid5.star_wars_travel.domain.entities.Theme
import com.paranid5.star_wars_travel.domain.theme.ThemeRepository
import com.paranid5.star_wars_travel.domain.utils.updateState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class SettingsComponentImpl(
    componentContext: ComponentContext,
    private val themeRepository: ThemeRepository,
) : SettingsComponent,
    ComponentContext by componentContext,
    StatePublisher<SettingsState> {

    private val componentState = getComponentState(
        defaultState = SettingsState(theme = Theme.DARK),
    )

    private val _stateFlow = MutableStateFlow(componentState.value)
    override val stateFlow = _stateFlow.asStateFlow()

    private var themeJob: Job? = null

    init {
        doOnStart {
            themeJob = componentScope.launch {
                themeRepository
                    .themeFlow
                    .collectLatest { theme -> updateState { copy(theme = theme) } }
            }
        }

        doOnStop {
            themeJob?.cancel()
            themeJob = null
        }
    }

    override fun onUiIntent(intent: SettingsUiIntent) {
        when (intent) {
            is SettingsUiIntent.ResetTheme -> componentScope.launch {
                themeRepository.storeTheme(intent.newTheme)
            }
        }
    }

    override fun updateState(func: SettingsState.() -> SettingsState) =
        _stateFlow.updateState(func)

    class Factory(
        private val themeRepository: ThemeRepository,
    ) : SettingsComponent.Factory {
        override fun create(componentContext: ComponentContext): SettingsComponent =
            SettingsComponentImpl(
                componentContext = componentContext,
                themeRepository = themeRepository,
            )
    }
}
