package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.hide
import com.paranid5.star_wars_travel.core.resources.show
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

internal typealias InfoItems = ImmutableList<Pair<String, ImmutableList<String>>>

@Composable
internal fun InfoMenu(
    mainLabel: String,
    items: InfoItems,
    modifier: Modifier = Modifier
) {
    var isMenuShown by remember { mutableStateOf(true) }

    val listHeight by remember(isMenuShown) {
        derivedStateOf { if (isMenuShown) Dp.Unspecified else 0.dp }
    }

    val infoVisibilityText by remember(isMenuShown) {
        derivedStateOf {
            when {
                isMenuShown -> Res.string.hide
                else -> Res.string.show
            }
        }
    }

    Column(modifier) {
        HeaderText(text = mainLabel)

        if (isMenuShown)
            Spacer(Modifier.height(AppTheme.dimensions.padding.extraMedium))

        LabelList(
            items = items,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = listHeight)
                .animateContentSize()
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.extraSmall))

        Text(
            text = stringResource(infoVisibilityText),
            color = AppTheme.colors.transparentUtility,
            style = AppTheme.typography.captionSm,
            modifier = Modifier.clickable { isMenuShown = isMenuShown.not() },
        )
    }
}
