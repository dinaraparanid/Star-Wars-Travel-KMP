package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun AppProgressIndicator(modifier: Modifier = Modifier) = Box(modifier) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center),
        color = AppTheme.colors.starWarsYellow,
    )
}