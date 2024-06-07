package com.paranid5.star_wars_travel.core.ui

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
sealed interface UiState<out T> {
    @Serializable
    data object Undefined : UiState<Nothing>

    @Serializable
    data object Loading : UiState<Nothing>

    @Serializable
    data class Refreshing<T>(val value: UiState<T>) : UiState<T>

    @Serializable
    data class Error(val errorMessage: String? = null) : UiState<Nothing>

    @Serializable
    data class Data<T>(val value: T) : UiState<T>
}

fun <T> UiState<T>.getOrNull() = when (this) {
    is UiState.Data -> value

    is UiState.Error,
    is UiState.Loading,
    is UiState.Refreshing,
    is UiState.Undefined -> null
}

fun <T> UiState<T>.getOrThrow() = when (this) {
    is UiState.Data -> value

    is UiState.Error,
    is UiState.Loading,
    is UiState.Refreshing,
    is UiState.Undefined -> error("State $this does not contain value")
}