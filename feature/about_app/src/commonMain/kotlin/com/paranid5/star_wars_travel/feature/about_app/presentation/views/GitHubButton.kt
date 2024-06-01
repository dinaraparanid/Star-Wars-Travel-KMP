package com.paranid5.star_wars_travel.feature.about_app.presentation.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.available_on_github
import com.paranid5.star_wars_travel.core.resources.github
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppUiIntent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val GITHUB_ICON_SIZE = 32.dp

@Composable
internal fun GitHubButton(
    aboutAppComponent: AboutAppComponent,
    modifier: Modifier = Modifier,
) {
    val padding = AppTheme.dimensions.padding
    val corners = AppTheme.dimensions.corners
    val colors = AppTheme.colors

    Button(
        shape = RoundedCornerShape(corners.extraSmall),
        colors = ButtonDefaults.buttonColors(containerColor = colors.onBackground),
        modifier = modifier,
        onClick = { aboutAppComponent.onUiIntent(AboutAppUiIntent.OpenProjectGitHub) }
    ) {
        GitHubIcon(
            Modifier
                .size(GITHUB_ICON_SIZE)
                .align(Alignment.CenterVertically)
        )

        Spacer(Modifier.width(padding.small))

        GitHubLabel(Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
private fun GitHubIcon(modifier: Modifier = Modifier) =
    Icon(
        painter = painterResource(Res.drawable.github),
        contentDescription = stringResource(Res.string.available_on_github),
        tint = AppTheme.colors.background,
        modifier = modifier
    )

@Composable
private fun GitHubLabel(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.available_on_github),
        style = AppTheme.typography.h.h3,
        color = AppTheme.colors.background,
        modifier = modifier,
    )