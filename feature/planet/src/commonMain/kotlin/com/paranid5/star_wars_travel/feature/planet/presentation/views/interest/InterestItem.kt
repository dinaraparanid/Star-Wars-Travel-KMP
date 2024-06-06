package com.paranid5.star_wars_travel.feature.planet.presentation.views.interest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.interest_preview
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.utils.AppProgressIndicator
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.InterestUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetPlaceholder
import com.paranid5.star_wars_travel.feature.planet.presentation.views.coverModel
import org.jetbrains.compose.resources.stringResource

private val COVER_SIZE = 60.dp

@Composable
internal fun InterestItem(
    interest: InterestUiState,
    modifier: Modifier = Modifier
) {
    val context = LocalPlatformContext.current

    Column(modifier) {
        SubcomposeAsyncImage(
            model = coverModel(
                coverUrl = interest.coverUrl,
                context = context,
            ),
            contentDescription = stringResource(Res.string.interest_preview),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            loading = { AppProgressIndicator(Modifier.fillMaxSize()) },
            error = { PlanetPlaceholder(Modifier.fillMaxSize()) },
            modifier = Modifier
                .size(COVER_SIZE)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.minimum))

        Text(
            text = interest.value,
            style = AppTheme.typography.captionSm,
            color = AppTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}