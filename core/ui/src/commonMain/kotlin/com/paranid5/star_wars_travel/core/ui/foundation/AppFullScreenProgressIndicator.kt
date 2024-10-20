package com.paranid5.star_wars_travel.core.ui.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import io.github.alexzhirkevich.cupertino.CupertinoActivityIndicator
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveWidget
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@OptIn(ExperimentalAdaptiveApi::class, ExperimentalCupertinoApi::class)
@Composable
fun AppFullScreenProgressIndicator(modifier: Modifier = Modifier) = Box(modifier) {
    AdaptiveWidget(
        material = {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colors.primary,
            )
        },
        cupertino = {
            CupertinoActivityIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colors.primary,
            )
        }
    )
}
