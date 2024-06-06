package com.paranid5.star_wars_travel.core.component

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.Store
import com.paranid5.star_wars_travel.core.component.ComponentStore.Initial
import com.paranid5.star_wars_travel.core.component.ComponentStore.Restored

inline fun <
    reified S : Any,
    reified T : Store<*, *, *>
    > StateSource<S>.getComponentStore(
    defaultState: S,
    noinline storeFactory: (S) -> T,
): ComponentStore<T> {
    val componentState = getComponentState(defaultState)
    val store = instanceKeeper.getStore { storeFactory(componentState.value) }
    return if (componentState is ComponentState.Initial) Initial(store) else Restored(store)
}

sealed interface ComponentStore<T : Store<*, *, *>> {

    val value: T

    data class Initial<T : Store<*, *, *>>(override val value: T) : ComponentStore<T>

    data class Restored<T : Store<*, *, *>>(override val value: T) : ComponentStore<T>
}

inline fun <T : Store<*, *, *>> ComponentStore<T>.onInitial(block: () -> Unit) {
    if (this is Initial) block()
}