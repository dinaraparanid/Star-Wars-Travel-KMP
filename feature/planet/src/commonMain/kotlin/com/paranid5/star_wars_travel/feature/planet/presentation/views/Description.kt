package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.description
import com.paranid5.star_wars_travel.core.resources.hide
import com.paranid5.star_wars_travel.core.resources.no_description
import com.paranid5.star_wars_travel.core.resources.show
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.component.HIDDEN_MAX_LINES
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent.State
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent.UiIntent
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun Description(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
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

    val planetDescription = state.planet.description ?: stringResource(Res.string.no_description)

    val textMeasurer = rememberTextMeasurer()

    val res = textMeasurer.measure(
        text = planetDescription,
        style = AppTheme.typography.regular,
    )

    Column(modifier) {
        HeaderText(text = stringResource(Res.string.description))

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        Text(
            text = planetDescription,
            color = AppTheme.colors.onBackground,
            style = AppTheme.typography.regular,
            overflow = TextOverflow.Ellipsis,
            maxLines = state.descriptionMaxLines,
            modifier = Modifier.animateContentSize()
        )

        if (res.lineCount <= HIDDEN_MAX_LINES) {
            Spacer(Modifier.height(AppTheme.dimensions.padding.extraSmall))

            Text(
                text = stringResource(descriptionVisibilityText),
                color = AppTheme.colors.transparentUtility,
                style = AppTheme.typography.captionSm,
                modifier = Modifier.clickable { onUiIntent(UiIntent.ChangeDescriptionVisibility) },
            )
        }
    }
}