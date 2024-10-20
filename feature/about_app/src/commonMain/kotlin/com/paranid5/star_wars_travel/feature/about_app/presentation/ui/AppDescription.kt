package com.paranid5.star_wars_travel.feature.about_app.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_description_1
import com.paranid5.star_wars_travel.core.resources.app_description_2
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AppDescription1(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.app_description_1),
        style = typography.h.h2.copy(fontWeight = FontWeight.Bold),
        color = colors.text.primary,
        modifier = modifier,
    )

@Composable
internal fun AppDescription2(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.app_description_2),
        style = typography.body,
        color = colors.text.primary,
        modifier = modifier,
    )