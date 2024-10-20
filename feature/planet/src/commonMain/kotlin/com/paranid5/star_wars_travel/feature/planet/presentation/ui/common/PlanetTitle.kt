package com.paranid5.star_wars_travel.feature.planet.presentation.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.paranid5.star_wars_travel.core.ui.StarJediFont
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography

@Composable
internal fun PlanetTitle(
    planetTitle: String,
    modifier: Modifier = Modifier,
    style: TextStyle = typography.regular,
) = Text(
    text = planetTitle,
    modifier = modifier,
    color = colors.text.itemDescription,
    style = style,
    fontFamily = StarJediFont,
)
