package com.paranid5.star_wars_travel.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.core.ui.LocalSnackbarHostState
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.presentation.navbar.NavBar
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveScaffold
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@Composable
internal expect fun MainScreen(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
)

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
internal fun MainScreenMobile(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = AdaptiveScaffold(
    modifier = modifier,
    bottomBar = { NavBar(rootComponent) },
    snackbarHost = { MainSnackbarHost() },
    containerColor = Color.Transparent,
    contentColor = Color.Transparent,
    content = { ContentScreen(rootComponent, paddingValues = it) }
)

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
internal fun MainScreenPC(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier,
) = Row(modifier) {
    NavBar(rootComponent)

    AdaptiveScaffold(
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
            shape = RoundedCornerShape(dimensions.corners.small),
            containerColor = colors.primary,
            contentColor = colors.text.onButton,
            dismissActionContentColor = colors.text.onButton,
        )
    }
}
