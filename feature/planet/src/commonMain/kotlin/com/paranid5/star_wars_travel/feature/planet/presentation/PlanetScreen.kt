package com.paranid5.star_wars_travel.feature.planet.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.astro_info
import com.paranid5.star_wars_travel.core.resources.phys_info
import com.paranid5.star_wars_travel.core.resources.soc_info
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.utils.onBackEvent
import com.paranid5.star_wars_travel.feature.planet.component.PlanetComponent
import com.paranid5.star_wars_travel.feature.planet.component.PlanetState
import com.paranid5.star_wars_travel.feature.planet.component.PlanetUiIntent
import com.paranid5.star_wars_travel.feature.planet.presentation.effects.TravelSnackbarEffect
import com.paranid5.star_wars_travel.feature.planet.presentation.utils.toEntryList
import com.paranid5.star_wars_travel.feature.planet.presentation.views.Description
import com.paranid5.star_wars_travel.feature.planet.presentation.views.InfoMenu
import com.paranid5.star_wars_travel.feature.planet.presentation.views.TopBarCover
import com.paranid5.star_wars_travel.feature.planet.presentation.views.interest.InterestsRow
import org.jetbrains.compose.resources.stringResource

@Composable
fun PlanetScreen(
    planetComponent: PlanetComponent,
    modifier: Modifier = Modifier,
) {
    val state by planetComponent.stateFlow.collectAsState()
    val onUiIntent = planetComponent::onUiIntent

    val appPadding = AppTheme.dimensions.padding
    val scrollState = rememberScrollState()

    TravelSnackbarEffect(
        planet = state.planet,
        isTravelSnackbarVisible = state.isTravelSnackbarShown,
        onDismissed = { onUiIntent(PlanetUiIntent.HideTravelSnackbar) },
    )

    Column(modifier) {
        TopBarCover(
            scrollValue = scrollState.value.toFloat(),
            state = state,
            onUiIntent = onUiIntent,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(appPadding.small))

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(AppTheme.dimensions.separators.minimum)
                .background(AppTheme.colors.transparentUtility),
        )

        PlanetScreenDetails(
            state = state,
            onUiIntent = onUiIntent,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .onBackEvent { onUiIntent(PlanetUiIntent.GoBack) }
        )
    }
}

@Composable
internal fun PlanetScreenDetails(
    state: PlanetState,
    onUiIntent: (PlanetUiIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val appPadding = AppTheme.dimensions.padding

    ConstraintLayout(modifier) {
        val (
            interests,
            description,
            astroInfo,
            physInfo,
            socInfo
        ) = createRefs()

        InterestsRow(
            planet = state.planet,
            modifier = Modifier.constrainAs(interests) {
                top.linkTo(parent.top, margin = appPadding.small)
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