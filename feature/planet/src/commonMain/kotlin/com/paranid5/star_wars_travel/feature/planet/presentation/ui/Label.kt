package com.paranid5.star_wars_travel.feature.planet.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography

@Composable
internal fun Label(text: String, modifier: Modifier = Modifier) =
    HeaderText(text = text, modifier = modifier, style = typography.regular)