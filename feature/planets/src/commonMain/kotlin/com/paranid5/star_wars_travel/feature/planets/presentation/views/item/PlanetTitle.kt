package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.paranid5.star_wars_travel.core.ui.StarJediFont
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
internal fun PlanetTitle(
    planetTitle: String,
    modifier: Modifier = Modifier,
    style: TextStyle = AppTheme.typography.regular,
) = Text(
    text = planetTitle,
    modifier = modifier,
    color = Color.White,
    style = style,
    fontFamily = StarJediFont,
)