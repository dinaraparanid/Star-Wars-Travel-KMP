package com.paranid5.star_wars_travel.feature.about_app.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.me
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppUiIntent
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppDeveloper(
    aboutAppComponent: AboutAppComponent,
    modifier: Modifier = Modifier,
) = Text(
    text = stringResource(Res.string.me),
    style = AppTheme.typography.body.copy(textDecoration = TextDecoration.Underline),
    color = AppTheme.colors.onBackground,
    modifier = modifier.clickable {
        aboutAppComponent.onUiIntent(AboutAppUiIntent.OpenMyGitHub)
    },
)
