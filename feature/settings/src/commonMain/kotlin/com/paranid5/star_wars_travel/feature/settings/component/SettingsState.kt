package com.paranid5.star_wars_travel.feature.settings.component

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class SettingsState(val theme: Theme)
