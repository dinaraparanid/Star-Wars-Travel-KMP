package com.paranid5.star_wars_travel.feature.about_app.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.me
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.core.ui.utils.clickableWithRipple
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppUiIntent
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppDeveloper(
    onUiIntent: (AboutAppUiIntent) -> Unit,
    modifier: Modifier = Modifier,
) = Text(
    text = stringResource(Res.string.me),
    style = typography.body.copy(textDecoration = TextDecoration.Underline),
    color = colors.text.primary,
    modifier = modifier.clickableWithRipple { onUiIntent(AboutAppUiIntent.OpenMyGitHub) },
)
