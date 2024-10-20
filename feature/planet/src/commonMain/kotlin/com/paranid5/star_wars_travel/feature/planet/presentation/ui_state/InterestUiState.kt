package com.paranid5.star_wars_travel.feature.planet.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.core.ui.UiState
import com.paranid5.star_wars_travel.core.ui.getOrNull
import com.paranid5.star_wars_travel.core.ui.toUiStateIfNotNull
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class InterestUiState(
    val value: String,
    val coverUrlState: UiState<String>,
) {
    constructor(entity: Interest) : this(
        value = entity.value,
        coverUrlState = entity.coverUrl.toUiStateIfNotNull()
    )
}

internal fun InterestUiState.toEntity(): Interest =
    Interest(value = value, coverUrl = coverUrlState.getOrNull())
