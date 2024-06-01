package com.paranid5.star_wars_travel.feature.planets.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsComponent

@Composable
fun PlanetsScreen(
    planetsComponent: PlanetsComponent,
    modifier: Modifier = Modifier,
) = Box(modifier) {
    Text("TODO: Planets Screen", Modifier.align(Alignment.Center))
}