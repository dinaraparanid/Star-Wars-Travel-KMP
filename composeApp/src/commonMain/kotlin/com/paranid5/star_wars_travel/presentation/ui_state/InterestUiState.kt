package com.paranid5.star_wars_travel.presentation.ui_state

import androidx.compose.runtime.Immutable
import com.paranid5.star_wars_travel.domain.entities.wookiepedia.Interest
import kotlinx.serialization.Serializable

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