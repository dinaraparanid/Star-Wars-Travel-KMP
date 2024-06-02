package com.paranid5.star_wars_travel.feature.settings.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.component.componentScope
import com.paranid5.star_wars_travel.data.StorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class SettingsComponentImpl(
    componentContext: ComponentContext,
    private val storageRepository: StorageRepository,
) : SettingsComponent,
    ComponentContext by componentContext {
    override val themeFlow by lazy {
        storageRepository.themeDataSource.themeFlow
    }

    override fun onUiIntent(intent: SettingsUiIntent) {
        componentScope.launch(Dispatchers.Default) {
            when (intent) {
                is SettingsUiIntent.ResetTheme ->
                    storageRepository.themeDataSource.storeTheme(intent.newTheme)
            }
        }
    }

    class Factory(
        private val storageRepository: StorageRepository,
    ) : SettingsComponent.Factory {
        override fun create(componentContext: ComponentContext): SettingsComponent =
            SettingsComponentImpl(
                componentContext = componentContext,
                storageRepository = storageRepository,
            )
    }
}
