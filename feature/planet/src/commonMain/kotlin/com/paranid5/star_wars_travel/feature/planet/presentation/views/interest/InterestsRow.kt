package com.paranid5.star_wars_travel.feature.planet.presentation.views.interest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PlanetUiState

private val ITEM_WIDTH = 100.dp

@Composable
internal fun InterestsRow(
    planet: PlanetUiState,
    modifier: Modifier = Modifier,
) = LazyRow(
    modifier = modifier,
    contentPadding = PaddingValues(end = AppTheme.dimensions.padding.extraMedium)
) {
    item { Spacer(Modifier.width(AppTheme.dimensions.padding.extraMedium)) }

    items(
        items = planet.physicalInformation.interests,
        key = { it.value }
    ) {
        Row {
            InterestItem(
                interest = it,
                modifier = Modifier.width(ITEM_WIDTH)
            )

            Spacer(Modifier.width(AppTheme.dimensions.padding.extraSmall))
        }
    }
}