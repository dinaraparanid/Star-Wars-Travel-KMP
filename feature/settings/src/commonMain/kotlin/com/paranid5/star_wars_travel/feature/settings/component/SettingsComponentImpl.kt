package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.domain.theme.ThemeRepository
import kotlinx.coroutines.launch

internal class SettingsComponentImpl(
    componentContext: ComponentContext,
    private val themeRepository: ThemeRepository,
) : SettingsComponent,
    ComponentContext by componentContext {
    override val themeFlow by lazy {
        themeRepository.themeFlow
    }

    override fun onUiIntent(intent: SettingsUiIntent) {
        when (intent) {
            is SettingsUiIntent.ResetTheme -> componentScope.launch {
                themeRepository.storeTheme(intent.newTheme)
            }
        }
    }

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
