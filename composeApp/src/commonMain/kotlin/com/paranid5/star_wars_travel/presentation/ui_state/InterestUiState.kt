package com.paranid5.star_wars_travel.presentation.ui_state

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest

@Immutable
@Serializable
data class InterestUiState(
    val value: String,
    val coverUrl: String?,
) {
    constructor(entity: Interest) : this(
        value = entity.value,
        coverUrl = entity.coverUrl
    )
}