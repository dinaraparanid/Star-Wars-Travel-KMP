package com.paranid5.star_wars_travel.feature.planet.presentation.ui.interest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.paranid5.star_wars_travel.core.ui.foundation.AppFullScreenProgressIndicator
import com.paranid5.star_wars_travel.core.ui.getOrNull
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.feature.planet.presentation.ui.common.CoverThumbnail
import com.paranid5.star_wars_travel.feature.planet.presentation.ui.coverModel
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.InterestUiState
import org.jetbrains.compose.resources.stringResource

private val CoverSize = 60.dp

@Composable
internal fun InterestItem(
    interest: InterestUiState,
    modifier: Modifier = Modifier,
) {
    val context = LocalPlatformContext.current

    Column(modifier) {
        SubcomposeAsyncImage(
            model = coverModel(
                coverUrl = interest.coverUrlState.getOrNull(),
                context = context,
            ),
            contentDescription = stringResource(Res.string.interest_preview),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            loading = { AppFullScreenProgressIndicator(Modifier.fillMaxSize()) },
            error = {
                CoverThumbnail(
                    coverUrlState = interest.coverUrlState,
                    modifier = Modifier.fillMaxSize(),
                )
            },
            modifier = Modifier
                .size(CoverSize)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
        )

        Spacer(Modifier.height(dimensions.padding.minimum))

        Text(
            text = interest.value,
            style = typography.captionSm,
            color = colors.text.primary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}
