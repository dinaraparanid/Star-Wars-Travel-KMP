package com.paranid5.star_wars_travel.core.utils.extensions

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.experimental.ExperimentalTypeInference

@OptIn(ExperimentalContracts::class, ExperimentalTypeInference::class)
inline fun <T> buildImmutableList(
    @BuilderInference builderAction: MutableList<T>.() -> Unit
): ImmutableList<T> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return persistentListOf<T>().mutate(builderAction)
}

fun <T> ImmutableList(size: Int, elem: T): ImmutableList<T> =
    buildImmutableList { repeat(size) { add(elem) } }

fun <T> List<T>?.orNil(): ImmutableList<T> = this?.toImmutableList() ?: persistentListOf()

fun <T> ImmutableList<T>?.orNil(): ImmutableList<T> = this ?: persistentListOf()

operator fun <T> ImmutableList<T>.plus(elem: T): ImmutableList<T> = buildImmutableList {
    addAll(this@plus)
    add(elem)
}
