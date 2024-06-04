package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.planet_preview
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.views.coverModel
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun PlanetCover(
    planet: PlanetUiState,
    modifier: Modifier = Modifier,
    roundedCorners: Dp = AppTheme.dimensions.corners.minimum,
) {
    val context = LocalPlatformContext.current

    AsyncImage(
        model = coverModel(planet.coverUrl, context),
        contentDescription = stringResource(Res.string.planet_preview),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(RoundedCornerShape(roundedCorners))
    )
}