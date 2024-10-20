package com.paranid5.star_wars_travel.core.utils

val doNothing = {}

fun <T> identity(x: T) = x

inline fun <T> Boolean.takeIfTrueOrNull(func: () -> T?) =
    if (this) func() else null
