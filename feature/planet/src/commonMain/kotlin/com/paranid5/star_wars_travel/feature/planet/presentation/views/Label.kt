package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun Label(text: String, modifier: Modifier = Modifier) =
    HeaderText(text = text, modifier = modifier, style = AppTheme.typography.regular)