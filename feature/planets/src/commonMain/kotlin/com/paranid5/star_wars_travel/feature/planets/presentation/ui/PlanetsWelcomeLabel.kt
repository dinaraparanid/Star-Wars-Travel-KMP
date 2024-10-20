package com.paranid5.star_wars_travel.feature.planets.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.planets_welcome_label
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun PlanetsWelcomeLabel(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.planets_welcome_label),
        modifier = modifier,
        color = colors.text.primary,
        style = typography.h.h2,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W700,
    )