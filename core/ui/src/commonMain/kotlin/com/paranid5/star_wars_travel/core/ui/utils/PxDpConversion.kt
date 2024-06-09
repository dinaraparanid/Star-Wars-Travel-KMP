package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Int.pxToDp() = LocalDensity.current.run { this@pxToDp.toDp() }

@Composable
fun Dp.toPx() = LocalDensity.current.run { this@toPx.toPx() }