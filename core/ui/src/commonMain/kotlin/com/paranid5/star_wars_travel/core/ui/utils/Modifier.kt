package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

inline fun Modifier.applyIf(
    condition: Boolean,
    block: Modifier.() -> Modifier
): Modifier = if (condition) block() else this

inline fun <T : Any> Modifier.applyIfNotNull(
    instance: T?,
    block: Modifier.(T) -> Modifier
): Modifier = if (instance != null) block(instance) else this

@Composable
inline fun Modifier.applyComposableIf(
    condition: Boolean,
    block: @Composable Modifier.() -> Modifier
): Modifier = if (condition) block() else this

@Composable
inline fun <T : Any> Modifier.applyComposableIfNotNull(
    instance: T?,
    block: @Composable Modifier.(T) -> Modifier
): Modifier = if (instance != null) block(instance) else this
