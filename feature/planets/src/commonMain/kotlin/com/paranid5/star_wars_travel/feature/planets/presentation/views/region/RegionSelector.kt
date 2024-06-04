package com.paranid5.star_wars_travel.feature.planets.presentation.views.region

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.all
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import org.jetbrains.compose.resources.stringResource

private val REGION_MIN_WIDTH = 60.dp

@Composable
internal fun RegionSelector(
    region: String?,
    isSelected: Boolean,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = AppTheme.colors

    val allItem = stringResource(Res.string.all)

    val regionText by remember(region, allItem) {
        derivedStateOf { region ?: allItem }
    }

    val backgroundColor by remember(isSelected) {
        derivedStateOf { if (isSelected) Color.Black else Color.White }
    }

    val textColor by remember(isSelected, colors) {
        derivedStateOf { if (isSelected) colors.starWarsYellow else Color.Black }
    }

    Card(
        shape = RoundedCornerShape(AppTheme.dimensions.padding.extraMedium),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        modifier = modifier
            .widthIn(min = REGION_MIN_WIDTH)
            .clickable { onUiIntent(UiIntent.ReselectRegion(region)) },
    ) {
        Text(
            text = regionText,
            color = textColor,
            style = AppTheme.typography.caption,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = AppTheme.dimensions.padding.extraSmall,
                    bottom = AppTheme.dimensions.padding.minimum,
                    start = AppTheme.dimensions.padding.small,
                    end = AppTheme.dimensions.padding.small,
                )
        )
    }
}