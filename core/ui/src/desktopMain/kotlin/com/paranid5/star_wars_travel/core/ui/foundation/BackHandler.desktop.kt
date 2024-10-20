package com.paranid5.star_wars_travel.core.ui.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent

@Composable
actual fun Modifier.onBackEvent(onBack: () -> Unit): Modifier {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    return this.focusRequester(focusRequester).onKeyEvent {
        onBackKeyEvent(event = it, onBack = onBack)
        true
    }
}

private inline fun onBackKeyEvent(
    event: KeyEvent,
    onBack: () -> Unit,
) = when {
    event.key == Key.Escape -> onBack()
    else -> Unit
}