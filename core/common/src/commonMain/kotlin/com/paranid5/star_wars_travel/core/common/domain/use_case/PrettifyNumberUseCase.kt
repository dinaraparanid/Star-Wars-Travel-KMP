package com.paranid5.star_wars_travel.core.common.domain.use_case

private val NUMBER_REGEX = Regex("(\\d+)")
private const val DIGIT_GROUP = 3

fun prettifyNumber(string: String) =
    string.replace(NUMBER_REGEX) { prettifyNumberImpl(it.groupValues[1]) }

private fun prettifyNumberImpl(numString: String) =
    numString
        .reversed()
        .chunked(DIGIT_GROUP)
        .joinToString(" ")
        .reversed()