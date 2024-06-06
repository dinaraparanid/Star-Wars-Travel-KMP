package com.paranid5.star_wars_travel.feature.planet.presentation.views.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.paranid5.star_wars_travel.core.ui.utils.AppProgressIndicator
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.views.coverModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PlanetCover(
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
        loading = { AppProgressIndicator(Modifier.fillMaxSize()) },
        error = { PlanetPlaceholder(Modifier.fillMaxSize()) },
        modifier = modifier.clip(RoundedCornerShape(roundedCorners)),
    )
}

@Composable
fun PlanetPlaceholder(modifier: Modifier = Modifier) = Image(
    painter = painterResource(Res.drawable.deathstar),
    contentDescription = null,
    modifier = modifier,
)
