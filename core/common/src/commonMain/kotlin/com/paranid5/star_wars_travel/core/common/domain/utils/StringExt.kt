package com.paranid5.star_wars_travel.core.common.domain.utils

fun String?.toIntOrZero() = this?.toIntOrNull() ?: 0

fun String?.toLongOrZero() = this?.toLongOrNull() ?: 0L