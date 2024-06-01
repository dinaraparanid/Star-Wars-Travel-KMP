package com.paranid5.star_wars_travel

import javax.swing.SwingUtilities

internal fun <T> runOnUiThread(block: () -> T): T {
    if (SwingUtilities.isEventDispatchThread())
        return block()

    var error: Throwable? = null
    var result: T? = null

    SwingUtilities.invokeAndWait {
        runCatching(block)
            .onSuccess { result = it }
            .onFailure { error = it }
    }

    error?.also { throw it }

    @Suppress("UNCHECKED_CAST")
    return result as T
}
