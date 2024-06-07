package com.paranid5.star_wars_travel.feature.planet.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent

@Composable
actual fun PlanetScreen(
    planetComponent: PlanetComponent,
    modifier: Modifier,
) = PlanetScreenPC(planetComponent, modifier)