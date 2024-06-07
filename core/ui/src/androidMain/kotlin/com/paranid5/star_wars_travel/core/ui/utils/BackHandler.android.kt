package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.compose.BackHandler as AndroidBackHandler

@Composable
actual fun Modifier.onBackEvent(onBack: () -> Unit): Modifier {
    AndroidBackHandler(onBack = onBack)
    return this
}