package com.paranid5.star_wars_travel.core.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.paranid5.star_wars_travel.core.common.domain.use_case.OpenBrowserUseCase

internal class OpenBrowserUseCaseImpl(private val context: Context) : OpenBrowserUseCase {
    override fun openBrowser(url: String): Boolean =
        runCatching {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                ).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            )
        }.fold(onSuccess = { true }, onFailure = { false })
}