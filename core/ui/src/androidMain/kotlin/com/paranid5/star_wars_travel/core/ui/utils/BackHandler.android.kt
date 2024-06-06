package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler as AndroidBackHandler

@Composable
actual fun BackHandler(onBack: () -> Unit) = AndroidBackHandler(onBack = onBack)