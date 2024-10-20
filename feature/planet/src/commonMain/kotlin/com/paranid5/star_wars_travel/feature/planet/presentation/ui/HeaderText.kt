package com.paranid5.star_wars_travel.feature.planet.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = typography.h.h2,
) = Text(
    text = text,
    color = colors.text.primary,
    style = style,
    modifier = modifier,
)
