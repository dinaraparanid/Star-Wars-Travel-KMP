package com.paranid5.star_wars_travel.core.ui.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun Modifier.onBackEvent(onBack: () -> Unit): Modifier