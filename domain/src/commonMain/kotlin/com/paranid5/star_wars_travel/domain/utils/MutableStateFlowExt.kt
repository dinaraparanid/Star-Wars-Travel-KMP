package com.paranid5.star_wars_travel.domain.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

fun <T> MutableStateFlow<T>.updateState(block: T.() -> T) = update { block(it) }