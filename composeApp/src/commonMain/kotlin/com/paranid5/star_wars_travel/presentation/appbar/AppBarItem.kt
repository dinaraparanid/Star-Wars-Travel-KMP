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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.presentation.ui.StarWarsYellow
import com.paranid5.star_wars_travel.presentation.ui.theme.AppTheme

private val ICON_SIZE = 24.dp

@Composable
internal fun AppBarItem(
    title: String,
    image: ImageVector,
    //screen: RootConfig,
    modifier: Modifier = Modifier,
    //screenMatches: (RootConfig) -> Boolean = { it == screen }
) = AppBarItemImpl(
    //screen = screen,
    modifier = modifier,
    icon = { AppBarIcon(title, image) }
)

@Composable
internal fun AppBarItem(
    title: String,
    image: Painter,
    //screen: RootConfig,
    modifier: Modifier = Modifier,
    //screenMatches: (RootConfig) -> Boolean = { it == screen }
) = AppBarItemImpl(
    //screen = screen,
    modifier = modifier,
    icon = { AppBarIcon(title, image) }
)

@Composable
private fun AppBarIcon(
    title: String,
    image: ImageVector,
    //screenMatches: (RootConfig) -> Boolean,
    modifier: Modifier = Modifier
) {
    //val itemColor by rememberItemColor(screenMatches)
    val itemColor = StarWarsYellow

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
    //screenMatches: (RootConfig) -> Boolean,
    modifier: Modifier = Modifier
) {
    //val itemColor by rememberItemColor(screenMatches)
    val itemColor = StarWarsYellow

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
    //screen: RootConfig,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    //val navigator = LocalNavigator.current!!

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
        ),
        elevation = null,
        shape = RoundedCornerShape(AppTheme.dimensions.corners.medium),
        onClick = { /*navigator navigateTo screen*/ },
        content = { icon() }
    )
}

//@Composable
//private fun rememberItemColor(screenMatches: (RootConfig) -> Boolean): State<Color> {
//    val navigator = LocalNavigator.current!!
//    val stack by navigator.stack.subscribeAsState()
//
//    val isScreenCurrent by remember(stack) {
//        derivedStateOf { screenMatches(stack.active.configuration) }
//    }
//
//    return remember(isScreenCurrent) {
//        derivedStateOf { if (isScreenCurrent) StarWarsHologram else StarWarsYellow }
//    }
//}