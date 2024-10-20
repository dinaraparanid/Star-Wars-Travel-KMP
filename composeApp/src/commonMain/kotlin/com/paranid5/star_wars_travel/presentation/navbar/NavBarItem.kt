package com.paranid5.star_wars_travel.presentation.navbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButton
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButtonColors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography

private val ICON_SIZE = 24.dp

@Composable
internal fun NavBarItem(
    title: String,
    image: ImageVector,
    isScreenCurrent: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = NavBarItemImpl(
    modifier = modifier,
    icon = { NavBarIcon(title, image, isScreenCurrent) },
    onClick = onClick,
)

@Composable
private fun NavBarIcon(
    title: String,
    image: ImageVector,
    isScreenCurrent: Boolean,
    modifier: Modifier = Modifier,
) {
    val itemColor by rememberItemColor(isScreenCurrent)

    Column(modifier) {
        Icon(
            imageVector = image,
            contentDescription = title,
            tint = itemColor,
            modifier = Modifier
                .size(ICON_SIZE)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(dimensions.padding.small))

        Text(
            text = title,
            color = itemColor,
            style = typography.caption,
            maxLines = 1,
        )
    }
}

@Composable
private fun NavBarItemImpl(
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = AdaptiveButton(
    modifier = modifier,
    colors = AdaptiveButtonColors(backgroundColor = Color.Transparent),
    elevation = null,
    shape = RoundedCornerShape(dimensions.corners.medium),
    onClick = onClick,
    content = { icon() },
)

@Composable
private fun rememberItemColor(isScreenCurrent: Boolean): State<Color> {
    val appBarColors = AppTheme.colors.appBar
    return remember(isScreenCurrent, appBarColors) {
        derivedStateOf {
            when {
                isScreenCurrent -> appBarColors.selectedTab
                else -> appBarColors.unselectedTab
            }
        }
    }
}
