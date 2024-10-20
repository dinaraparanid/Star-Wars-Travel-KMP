package com.paranid5.star_wars_travel.core.ui.theme

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.paranid5.star_wars_travel.core.ui.LocalSnackbarHostState
import com.paranid5.star_wars_travel.domain.entities.Theme
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTheme
import io.github.alexzhirkevich.cupertino.adaptive.CupertinoThemeSpec
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.MaterialThemeSpec

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun AppTheme(
    theme: Theme,
    dimensions: AppDimensions = AppDimensions.default,
    typography: AppTypography = AppTypography.default,
    content: @Composable () -> Unit,
) {
    val colors by remember(theme) {
        derivedStateOf { AppColors.create(theme) }
    }

    val snackbarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography,
        LocalSnackbarHostState provides snackbarHostState,
    ) {
        AdaptiveTheme(
            material = MaterialThemeSpec.Default(),
            cupertino = CupertinoThemeSpec.Default(),
            content = content,
        )
    }
}

object AppTheme {
    val colors: AppColors @Composable get() = LocalColors.current
    val dimensions: AppDimensions @Composable get() = LocalDimensions.current
    val typography: AppTypography @Composable get() = LocalTypography.current
}
