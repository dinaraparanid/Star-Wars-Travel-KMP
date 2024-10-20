package com.paranid5.star_wars_travel.component.root

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class RootState(val theme: Theme = Theme.DARK)
