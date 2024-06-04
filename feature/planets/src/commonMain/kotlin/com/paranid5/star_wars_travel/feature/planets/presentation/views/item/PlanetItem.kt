package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState

@Composable
internal fun PlanetItem(
    planet: PlanetUiState,
    modifier: Modifier = Modifier
) = ConstraintLayout(modifier) {
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
            modifier = Modifier.constrainAs(travel) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        ) {
            // TODO: Show travel message
        }
    }
}