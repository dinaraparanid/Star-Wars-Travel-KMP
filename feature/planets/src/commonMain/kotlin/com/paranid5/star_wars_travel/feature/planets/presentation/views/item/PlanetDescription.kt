package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.climate_label
import com.paranid5.star_wars_travel.core.resources.gravity_label
import com.paranid5.star_wars_travel.core.resources.population_label
import com.paranid5.star_wars_travel.core.resources.secret_location
import com.paranid5.star_wars_travel.core.resources.unknown
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.mainRegion
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun PlanetDescription(planet: PlanetUiState, modifier: Modifier = Modifier) =
    Column(modifier) {
        PlanetTitle(planet.title)

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraSmall))

        PlanetInfoLabel(
            info = planet.mainRegion
                ?: stringResource(Res.string.secret_location),
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.minimum))

        PlanetInfoLabel(
            info = stringResource(
                Res.string.climate_label,
                planet.physicalInformation.climate
            ),
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.minimum))

        PlanetInfoLabel(
            info = stringResource(
                Res.string.gravity_label,
                planet.physicalInformation.gravity
            ),
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.minimum))

        PlanetInfoLabel(
            info = stringResource(
                Res.string.population_label,
                populationLabel(planet)
            ),
        )
    }

@Composable
private fun populationLabel(planet: PlanetUiState) =
    when (val pop = planet.societalInformation.population) {
        0L -> stringResource(Res.string.unknown)
        else -> pop.toString()
    }