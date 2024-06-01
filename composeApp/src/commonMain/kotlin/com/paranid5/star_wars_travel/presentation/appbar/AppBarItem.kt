package com.paranid5.star_wars_travel.presentation.appbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

private val ICON_SIZE = 24.dp

@Composable
internal fun AppBarItem(
    title: String,
    image: ImageVector,
    isScreenCurrent: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = AppBarItemImpl(
    modifier = modifier,
    icon = { AppBarIcon(title, image, isScreenCurrent) },
    onClick = onClick,
)

@Composable
internal fun AppBarItem(
    title: String,
    image: Painter,
    isScreenCurrent: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = AppBarItemImpl(
    modifier = modifier,
    icon = { AppBarIcon(title, image, isScreenCurrent) },
    onClick = onClick,
)

@Composable
private fun AppBarIcon(
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

        Spacer(Modifier.height(AppTheme.dimensions.padding.small))

        Text(
            text = title,
            color = itemColor,
            style = AppTheme.typography.caption,
        )
    }
}

@Composable
private fun AppBarIcon(
    title: String,
    image: Painter,
    isScreenCurrent: Boolean,
    modifier: Modifier = Modifier,
) {
    val itemColor by rememberItemColor(isScreenCurrent)

    Column(modifier) {
        Icon(
            painter = image,
            contentDescription = title,
            tint = itemColor,
            modifier = Modifier
                .size(ICON_SIZE)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(AppTheme.dimensions.padding.small))

        Text(
            text = title,
            color = itemColor,
            style = AppTheme.typography.caption,
        )
    }
}

@Composable
private fun AppBarItemImpl(
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = Button(
    modifier = modifier,
    colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent,
    ),
    elevation = null,
    shape = RoundedCornerShape(AppTheme.dimensions.corners.medium),
    onClick = onClick,
    content = { icon() },
)

@Composable
private fun rememberItemColor(isScreenCurrent: Boolean): State<Color> {
    val colors = AppTheme.colors
    return remember(isScreenCurrent, colors) {
        derivedStateOf { colors.getTabColor(isScreenCurrent) }
    }
}