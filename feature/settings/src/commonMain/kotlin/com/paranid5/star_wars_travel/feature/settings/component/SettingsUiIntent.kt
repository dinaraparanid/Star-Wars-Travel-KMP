package com.paranid5.star_wars_travel.feature.settings.component

import com.paranid5.star_wars_travel.domain.entities.Theme

sealed interface SettingsUiIntent {
    data class ResetTheme(val newTheme: Theme) : SettingsUiIntent
}
