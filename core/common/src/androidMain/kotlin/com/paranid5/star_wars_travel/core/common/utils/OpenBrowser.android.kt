package com.paranid5.star_wars_travel.core.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual fun openBrowser(url: String): Boolean = UrlOpener.openUrl(url)

private object UrlOpener : KoinComponent {
    private val applicationContext by inject<Context>()

    fun openUrl(url: String) = runCatching {
        applicationContext.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            ).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        )
    }.fold(onSuccess = { true }, onFailure = { false })
}