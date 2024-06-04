package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
fun LabelValues(values: ImmutableList<String>, modifier: Modifier = Modifier) =
    when (values.size) {
        1 -> SingleValue(
            value = values.first(),
            modifier = modifier
        )

        else -> ValuesList(
            values = values,
            modifier = modifier
        )
    }

@Composable
private fun SingleValue(value: String, modifier: Modifier = Modifier) =
    Text(
        text = value,
        modifier = modifier,
        color = AppTheme.colors.onBackground,
        style = AppTheme.typography.regular,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

@Composable
private fun ValuesList(values: ImmutableList<String>, modifier: Modifier = Modifier) =
    Column(modifier) { values.forEach { ValuesItem(value = it) } }

@Composable
private fun ValuesItem(value: String, modifier: Modifier = Modifier) {
    val colors = AppTheme.colors

    Row(modifier) {
        Canvas(Modifier.align(Alignment.CenterVertically)) {
            drawCircle(
                color = colors.onBackground,
                radius = 6F
            )
        }

        Spacer(Modifier.width(AppTheme.dimensions.padding.small))

        SingleValue(
            value = value,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}