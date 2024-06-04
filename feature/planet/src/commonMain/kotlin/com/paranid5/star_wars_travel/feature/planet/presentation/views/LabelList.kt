package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun LabelList(items: InfoItems, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.padding.extraSmall)
    ) {
        items.forEachIndexed { i, (label, values) ->
            Column(Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth()) {
                    Label(
                        text = label,
                        modifier = Modifier.weight(1F)
                    )

                    LabelValues(
                        values = values,
                        modifier = Modifier.weight(1F)
                    )
                }

                if (i < items.lastIndex)
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(AppTheme.dimensions.separators.minimum)
                            .background(AppTheme.colors.transparentUtility)
                    )
            }
        }
    }
}