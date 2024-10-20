package com.paranid5.star_wars_travel.core.ui

import androidx.compose.runtime.Immutable
import com.arkivanov.essenty.statekeeper.SerializableContainer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

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
    data class Data<T>(private val container: SerializableContainer) : UiState<T> {
        fun <T : Any> getValue(serializer: KSerializer<T>): T? =
            container.consume(serializer)?.also { value -> container.set(value, serializer) }
    }
}

inline fun <reified T> UiState<T>.getOrNull(): T? = when (this) {
    is UiState.Data -> getValue(serializer())
    is UiState.Refreshing -> (value as? UiState.Data)?.getValue(serializer())
    is UiState.Error, is UiState.Loading, is UiState.Undefined -> null
}

inline fun <reified T> UiState<T>.getOrThrow(): T {
    check(this is UiState.Data<T> || this is UiState.Refreshing<T>) {
        "Only Data and Refreshing states are allowed, this state is $this"
    }

    return requireNotNull(getOrNull()) { "Serializable container with no State" }
}

inline fun <reified D : Any> D.toUiState() =
    UiState.Data<D>(SerializableContainer(this, serializer()))

inline fun <reified D : Any> D?.toUiStateIfNotNull() =
    this?.toUiState() ?: UiState.Error()
