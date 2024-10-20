package com.paranid5.star_wars_travel.domain.utils

fun String?.toIntOrZero(): Int = this?.toIntOrNull() ?: 0

fun String?.toLongOrZero(): Long = this?.toLongOrNull() ?: 0L
