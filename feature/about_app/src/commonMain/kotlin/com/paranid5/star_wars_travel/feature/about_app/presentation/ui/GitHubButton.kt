package com.paranid5.star_wars_travel.feature.about_app.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.available_on_github
import com.paranid5.star_wars_travel.core.resources.github
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButton
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButtonColors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppUiIntent
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

private val GITHUB_ICON_SIZE = 32.dp

@Composable
internal fun GitHubButton(
    onUiIntent: (AboutAppUiIntent) -> Unit,
    modifier: Modifier = Modifier,
) = AdaptiveButton(
    modifier = modifier,
    shape = RoundedCornerShape(dimensions.corners.extraSmall),
    colors = AdaptiveButtonColors(backgroundColor = colors.text.primary),
    onClick = { onUiIntent(AboutAppUiIntent.OpenProjectGitHub) },
) {
    GitHubIcon(
        Modifier
            .size(GITHUB_ICON_SIZE)
            .align(Alignment.CenterVertically),
    )

    Spacer(Modifier.width(dimensions.padding.small))

    GitHubLabel(Modifier.align(Alignment.CenterVertically))
}

@Composable
private fun GitHubIcon(modifier: Modifier = Modifier) =
    Icon(
        imageVector = vectorResource(Res.drawable.github),
        contentDescription = stringResource(Res.string.available_on_github),
        tint = colors.background.primary,
        modifier = modifier,
    )

@Composable
private fun GitHubLabel(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.available_on_github),
        style = typography.h.h4,
        color = colors.background.primary,
        modifier = modifier,
    )
