package com.paranid5.star_wars_travel.feature.planet.presentation.ui.interest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.InterestUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState

private val ItemWidth = 100.dp

@Composable
internal fun InterestsRow(
    planet: PlanetUiState,
    modifier: Modifier = Modifier,
) = LazyRow(
    modifier = modifier,
    contentPadding = PaddingValues(horizontal = dimensions.padding.extraMedium),
    horizontalArrangement = Arrangement.spacedBy(dimensions.padding.extraSmall),
) {
    items(
        items = planet.physicalInformation.interests,
        key = InterestUiState::value,
    ) { item ->
        InterestItem(
            interest = item,
            modifier = Modifier.width(ItemWidth),
        )
    }
}
