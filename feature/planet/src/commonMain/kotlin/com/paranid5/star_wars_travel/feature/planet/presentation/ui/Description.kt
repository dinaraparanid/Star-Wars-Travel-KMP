package com.paranid5.star_wars_travel.feature.planet.presentation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.description
import com.paranid5.star_wars_travel.core.resources.hide
import com.paranid5.star_wars_travel.core.resources.no_description
import com.paranid5.star_wars_travel.core.resources.show
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.core.ui.utils.clickableWithRipple
import com.paranid5.star_wars_travel.feature.planet.component.HiddenMaxLines
import com.paranid5.star_wars_travel.feature.planet.component.PlanetState
import com.paranid5.star_wars_travel.feature.planet.component.PlanetUiIntent
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun Description(
    state: PlanetState,
    onUiIntent: (PlanetUiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val descriptionVisibilityText by remember(state.isDescriptionShown) {
        derivedStateOf {
            when {
                state.isDescriptionShown -> Res.string.hide
                else -> Res.string.show
            }
        }
    }

    val planetDescription = state.planet.description
        ?: stringResource(Res.string.no_description)

    var lines by remember { mutableStateOf(0) }

    Column(modifier) {
        HeaderText(text = stringResource(Res.string.description))

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        Text(
            text = planetDescription,
            color = colors.text.primary,
            style = typography.regular,
            overflow = TextOverflow.Ellipsis,
            maxLines = state.descriptionMaxLines,
            modifier = Modifier.animateContentSize(),
            onTextLayout = { res -> lines = res.lineCount },
        )

        if (lines <= HiddenMaxLines) {
            Spacer(Modifier.height(AppTheme.dimensions.padding.extraSmall))

            Text(
                text = stringResource(descriptionVisibilityText),
                color = colors.transparentUtility,
                style = typography.captionSm,
                modifier = Modifier.clickableWithRipple {
                    onUiIntent(PlanetUiIntent.ChangeDescriptionVisibility)
                },
            )
        }
    }
}
