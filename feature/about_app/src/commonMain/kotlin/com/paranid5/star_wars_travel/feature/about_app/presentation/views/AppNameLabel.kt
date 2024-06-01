package com.paranid5.star_wars_travel.feature.about_app.presentation.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_name
import com.paranid5.star_wars_travel.core.ui.StarJediFont
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AppNameLabel(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.app_name),
        style = AppTheme.typography.h.h1,
        fontFamily = StarJediFont,
        color = AppTheme.colors.onBackground,
        modifier = modifier,
    )