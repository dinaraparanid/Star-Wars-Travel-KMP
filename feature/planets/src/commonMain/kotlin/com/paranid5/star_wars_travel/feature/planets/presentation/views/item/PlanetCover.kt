package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.deathstar
import com.paranid5.star_wars_travel.core.resources.planet_preview
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.views.coverModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun PlanetCover(
    planet: PlanetUiState,
    modifier: Modifier = Modifier,
    roundedCorners: Dp = AppTheme.dimensions.corners.minimum,
) {
    val context = LocalPlatformContext.current

    SubcomposeAsyncImage(
        model = coverModel(planet.coverUrl, context),
        contentDescription = stringResource(Res.string.planet_preview),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        loading = {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = AppTheme.colors.starWarsYellow,
                )
            }
        },
        error = { PlanetPlaceholder(Modifier.fillMaxSize()) },
        modifier = modifier.clip(RoundedCornerShape(roundedCorners)),
    )
}

@Composable
private fun PlanetPlaceholder(modifier: Modifier = Modifier) = Image(
    painter = painterResource(Res.drawable.deathstar),
    contentDescription = null,
    modifier = modifier,
)
