package com.paranid5.star_wars_travel.core.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun BackButton(modifier: Modifier = Modifier, onBack: () -> Unit) =
    IconButton(modifier = modifier, onClick = onBack) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = AppTheme.colors.starWarsYellow,
        )
    }