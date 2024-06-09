package com.paranid5.star_wars_travel.feature.planet.presentation.views.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.deathstar
import com.paranid5.star_wars_travel.core.resources.planet_preview
import com.paranid5.star_wars_travel.core.ui.UiState
import com.paranid5.star_wars_travel.core.ui.getOrNull
import com.paranid5.star_wars_travel.core.ui.utils.AppProgressIndicator
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.views.coverModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PlanetCover(
    planet: PlanetUiState,
    modifier: Modifier = Modifier,
) {
    val context = LocalPlatformContext.current

    SubcomposeAsyncImage(
        model = coverModel(
            coverUrl = planet.coverUrl.getOrNull(),
            context = context,
        ),
        contentDescription = stringResource(Res.string.planet_preview),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        loading = { AppProgressIndicator(Modifier.fillMaxSize()) },
        error = {
            CoverThumbnail(
                coverUrlState = planet.coverUrl,
                modifier = Modifier.fillMaxSize(),
            )
        },
        modifier = modifier,
    )
}

@Composable
fun PlanetPlaceholder(modifier: Modifier = Modifier) = Image(
    painter = painterResource(Res.drawable.deathstar),
    contentDescription = null,
    modifier = modifier,
)

@Composable
fun CoverThumbnail(
    coverUrlState: UiState<String>,
    modifier: Modifier = Modifier,
) = when (coverUrlState) {
    is UiState.Data -> PlanetPlaceholder(modifier)
    is UiState.Error -> PlanetPlaceholder(modifier)
    is UiState.Loading -> AppProgressIndicator(modifier)
    is UiState.Refreshing -> AppProgressIndicator(modifier)
    is UiState.Undefined -> AppProgressIndicator(modifier)
}
