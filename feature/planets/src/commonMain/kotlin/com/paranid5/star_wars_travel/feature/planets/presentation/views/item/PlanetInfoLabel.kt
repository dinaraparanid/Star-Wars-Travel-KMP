package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.domain.use_case.prettifyNumber

@Composable
internal fun PlanetInfoLabel(
    info: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) = Text(
    text = prettifyNumber(info),
    modifier = modifier,
    color = Color.White,
    style = AppTheme.typography.caption,
    fontFamily = FontFamily.SansSerif,
    maxLines = maxLines,
    overflow = overflow,
)