package com.paranid5.star_wars_travel.feature.planet.presentation

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.astro_info
import com.paranid5.star_wars_travel.core.resources.phys_info
import com.paranid5.star_wars_travel.core.resources.soc_info
import com.paranid5.star_wars_travel.core.ui.common.BackButton
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.utils.onBackEvent
import com.paranid5.star_wars_travel.feature.planet.component.PlanetState
import com.paranid5.star_wars_travel.feature.planet.component.PlanetUiIntent
import com.paranid5.star_wars_travel.feature.planet.presentation.utils.toEntryList
import com.paranid5.star_wars_travel.feature.planet.presentation.views.Description
import com.paranid5.star_wars_travel.feature.planet.presentation.views.InfoMenu
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetCover
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetTitle
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.TravelButton
import com.paranid5.star_wars_travel.feature.planet.presentation.views.interest.InterestsRow
import org.jetbrains.compose.resources.stringResource

@Composable
internal actual fun PlanetScreenImpl(
    state: PlanetState,
    onUiIntent: (PlanetUiIntent) -> Unit,
    modifier: Modifier,
) {
    val appPadding = AppTheme.dimensions.padding

    ConstraintLayout(
        modifier
            .verticalScroll(rememberScrollState())
            .onBackEvent { onUiIntent(PlanetUiIntent.GoBack) }
    ) {
        val (
            title,
            backButton,
            cover,
            travelButton,
            interests,
            description,
            astroInfo,
            physInfo,
            socInfo
        ) = createRefs()

        PlanetTitle(
            planetTitle = state.planet.title,
            style = AppTheme.typography.h.h2,
            modifier = Modifier
                .zIndex(1F)
                .constrainAs(title) {
                    bottom.linkTo(travelButton.top, margin = appPadding.small)
                    start.linkTo(travelButton.start)
                }
        )

        BackButton(
            onBack = { onUiIntent(PlanetUiIntent.GoBack) },
            modifier = Modifier
                .zIndex(1F)
                .constrainAs(backButton) {
                    top.linkTo(parent.top, margin = appPadding.small)
                    start.linkTo(parent.start, margin = appPadding.small)
                },
        )

        PlanetCover(
            planet = state.planet,
            roundedCorners = 0.dp,
            modifier = Modifier
                .aspectRatio(1F)
                .constrainAs(cover) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        TravelButton(
            onClick = { onUiIntent(PlanetUiIntent.ShowTravelSnackbar) },
            modifier = Modifier.constrainAs(travelButton) {
                centerAround(cover.bottom)
                start.linkTo(cover.start, margin = appPadding.large)
                end.linkTo(cover.end, margin = appPadding.large)
                width = Dimension.fillToConstraints
            }
        )

        InterestsRow(
            planet = state.planet,
            modifier = Modifier.constrainAs(interests) {
                top.linkTo(travelButton.bottom, margin = appPadding.extraMedium)
            }
        )

        Description(
            state = state,
            onUiIntent = onUiIntent,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(interests.bottom, margin = appPadding.extraMedium)
                start.linkTo(parent.start, margin = appPadding.extraMedium)
                end.linkTo(parent.end, margin = appPadding.extraMedium)
                width = Dimension.fillToConstraints
            },
        )

        InfoMenu(
            mainLabel = stringResource(Res.string.astro_info),
            items = state.planet.astrographicalInformation.toEntryList(),
            modifier = Modifier.constrainAs(astroInfo) {
                top.linkTo(description.bottom, margin = appPadding.extraMedium)
                start.linkTo(parent.start, margin = appPadding.extraMedium)
                end.linkTo(parent.end, margin = appPadding.extraMedium)
                width = Dimension.fillToConstraints
            }
        )

        InfoMenu(
            mainLabel = stringResource(Res.string.phys_info),
            items = state.planet.physicalInformation.toEntryList(),
            modifier = Modifier.constrainAs(physInfo) {
                top.linkTo(astroInfo.bottom, margin = appPadding.extraMedium)
                start.linkTo(parent.start, margin = appPadding.extraMedium)
                end.linkTo(parent.end, margin = appPadding.extraMedium)
                width = Dimension.fillToConstraints
            }
        )

        InfoMenu(
            mainLabel = stringResource(Res.string.soc_info),
            items = state.planet.societalInformation.toEntryList(),
            modifier = Modifier.constrainAs(socInfo) {
                top.linkTo(physInfo.bottom, margin = appPadding.extraMedium)
                start.linkTo(parent.start, margin = appPadding.extraMedium)
                end.linkTo(parent.end, margin = appPadding.extraMedium)
                bottom.linkTo(parent.bottom, margin = appPadding.extraMedium)
                width = Dimension.fillToConstraints
            }
        )
    }
}