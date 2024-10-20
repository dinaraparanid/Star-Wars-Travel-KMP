package com.paranid5.star_wars_travel.feature.planets.presentation.ui.region

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.all
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
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
    val colors = colors

    val allItem = stringResource(Res.string.all)

    val regionText by remember(region, allItem) {
        derivedStateOf { region ?: allItem }
    }

    val backgroundColor by animateColorAsState(
        targetValue = colors.chips.run { if (isSelected) selected else unselected },
        label = "region chips background color",
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) colors.primary else colors.text.onButton,
        label = "region chips text color",
    )

    Card(
        shape = RoundedCornerShape(dimensions.padding.extraMedium),
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
            style = typography.caption,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    vertical = dimensions.padding.small,
                    horizontal = dimensions.padding.medium,
                )
        )
    }
}
