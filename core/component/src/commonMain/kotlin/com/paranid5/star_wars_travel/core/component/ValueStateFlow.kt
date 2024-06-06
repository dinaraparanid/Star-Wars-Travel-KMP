package com.paranid5.star_wars_travel.core.component

import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T : Any> Value<T>.toStateFlow(): StateFlow<T> = ValueStateFlow(this)

private data class ValueStateFlow<out T : Any>(private val source: Value<T>) : StateFlow<T> {

    override val value: T
        get() = source.value

    override val replayCache: List<T>
        get() = listOf(source.value)

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        val flow = MutableStateFlow(source.value)
        val observer: (T) -> Unit = { flow.value = it }
        val cancellable = source.subscribe(observer)
        try {
            flow.collect(collector)
        } finally {
            cancellable.cancel()
        }
    }
}
