package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = AppTheme.typography.h.h2,
) = Text(
    text = text,
    color = AppTheme.colors.onBackground,
    style = style,
    modifier = modifier
)