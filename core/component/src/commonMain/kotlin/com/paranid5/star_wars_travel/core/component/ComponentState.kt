package com.paranid5.star_wars_travel.core.component

import com.paranid5.star_wars_travel.core.component.ComponentState.Initial
import com.paranid5.star_wars_travel.core.component.ComponentState.Restored
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import kotlin.reflect.typeOf

inline fun <reified State : Any> StateSource<State>.getComponentState(
    defaultState: State,
): ComponentState<State> {
    @Suppress("UNCHECKED_CAST")
    val strategy = serializer(typeOf<State>()) as KSerializer<State>
    val key = requireNotNull(State::class.qualifiedName)
    stateKeeper.register(key = key, strategy = strategy, supplier = { stateFlow.value })
    val restoredState = stateKeeper.consume(key = key, strategy = strategy)
    return if (restoredState == null) Initial(defaultState) else Restored(restoredState)
}

sealed interface ComponentState<T : Any> {

    val value: T

    data class Initial<T : Any>(override val value: T) : ComponentState<T>

    data class Restored<T : Any>(override val value: T) : ComponentState<T>

    fun onInitial(block: () -> Unit) {
        if (this is Initial) block()
    }
}