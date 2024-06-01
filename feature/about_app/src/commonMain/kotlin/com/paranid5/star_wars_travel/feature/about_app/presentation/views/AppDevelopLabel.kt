package com.paranid5.star_wars_travel.feature.about_app.presentation.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.developer
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AppDeveloperLabel(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.developer),
        style = AppTheme.typography.h.h2.copy(fontWeight = FontWeight.Bold),
        color = AppTheme.colors.onBackground,
        modifier = modifier,
    )