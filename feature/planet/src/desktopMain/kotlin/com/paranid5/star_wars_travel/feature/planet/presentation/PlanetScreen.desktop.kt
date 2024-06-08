package com.paranid5.star_wars_travel.feature.planet.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.feature.planet.component.PlanetState
import com.paranid5.star_wars_travel.feature.planet.component.PlanetUiIntent

@Composable
internal actual fun PlanetScreenImpl(
    state: PlanetState,
    onUiIntent: (PlanetUiIntent) -> Unit,
    modifier: Modifier,
) = PlanetScreenPC(
    state = state,
    onUiIntent = onUiIntent,
    modifier = modifier,
)