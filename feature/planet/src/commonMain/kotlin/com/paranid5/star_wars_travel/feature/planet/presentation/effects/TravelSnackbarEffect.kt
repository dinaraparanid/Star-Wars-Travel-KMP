package com.paranid5.star_wars_travel.feature.planet.presentation.effects

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.enjoy_journey_to
import com.paranid5.star_wars_travel.core.ui.LocalSnackbarHostState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import org.jetbrains.compose.resources.stringResource

@Composable
fun TravelSnackbarEffect(
    planet: PlanetUiState,
    isTravelSnackbarVisible: Boolean,
    onDismissed: () -> Unit,
) {
    val snackbarHostState = LocalSnackbarHostState.current
    val travelMessage = stringResource(Res.string.enjoy_journey_to, planet.title)

    LaunchedEffect(isTravelSnackbarVisible, snackbarHostState) {
        if (isTravelSnackbarVisible) {
            val res = snackbarHostState?.showSnackbar(
                message = travelMessage,
                duration = SnackbarDuration.Long,
                withDismissAction = true,
            )

            when (res) {
                SnackbarResult.Dismissed -> onDismissed()
                SnackbarResult.ActionPerformed, null -> Unit
            }
        }
    }
}
