package com.paranid5.star_wars_travel.feature.planets.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.effects.TravelSnackbarEffect
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetCover
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetDescription
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.TravelButton
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent

@Composable
internal fun PlanetItem(
    planet: PlanetUiState,
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    TravelSnackbarEffect(
        planet = planet,
        isTravelSnackbarVisible = state.isTravelSnackbarShown,
        onDismissed = { onUiIntent(UiIntent.HideTravelSnackbar) }
    )

    ConstraintLayout(modifier) {
        val appPadding = AppTheme.dimensions.padding
        val (cover, description) = createRefs()

        PlanetCover(
            planet = planet,
            modifier = Modifier.constrainAs(cover) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )

        ConstraintLayout(
            Modifier.constrainAs(description) {
                bottom.linkTo(parent.bottom, margin = appPadding.small)
                start.linkTo(parent.start, margin = appPadding.small)
                end.linkTo(parent.end, margin = appPadding.small)
                width = Dimension.fillToConstraints
            }
        ) {
            val (desc, travel) = createRefs()

            PlanetDescription(
                planet = planet,
                modifier = Modifier.constrainAs(desc) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start)
                    end.linkTo(travel.start, margin = appPadding.small)
                    width = Dimension.fillToConstraints
                }
            )

            TravelButton(
                onClick = { onUiIntent(UiIntent.ShowTravelSnackbar) },
                modifier = Modifier.constrainAs(travel) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            )
        }
    }
}