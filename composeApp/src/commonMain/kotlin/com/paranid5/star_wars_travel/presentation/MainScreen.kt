package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.LocalSnackbarHostState
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.presentation.navbar.NavBar

@Composable
internal expect fun MainScreen(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
)

@Composable
internal fun MainScreenMobile(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = Scaffold(
    modifier = modifier,
    bottomBar = { NavBar(rootComponent) },
    snackbarHost = { MainSnackbarHost() },
    containerColor = Color.Transparent,
    contentColor = Color.Transparent,
    content = { ContentScreen(rootComponent, paddingValues = it) }
)

@Composable
internal fun MainScreenPC(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = Row(modifier) {
    NavBar(rootComponent)

    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        snackbarHost = { MainSnackbarHost() },
        content = { ContentScreen(rootComponent, paddingValues = it) }
    )
}

@Composable
private fun MainSnackbarHost(modifier: Modifier = Modifier) {
    val snackbarHostState = LocalSnackbarHostState.current ?: return

    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier
    ) { data ->
        Snackbar(
            snackbarData = data,
            shape = RoundedCornerShape(AppTheme.dimensions.corners.small),
            containerColor = AppTheme.colors.starWarsYellow
        )
    }
}
