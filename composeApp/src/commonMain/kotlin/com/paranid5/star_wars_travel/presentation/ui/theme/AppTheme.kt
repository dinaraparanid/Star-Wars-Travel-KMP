package com.paranid5.star_wars_travel.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import org.koin.compose.KoinContext

@Composable
internal fun AppTheme(
    theme: Theme,
    dimensions: AppDimensions = AppDimensions.default,
    typography: AppTypography = AppTypography.default,
    content: @Composable () -> Unit,
) {
    val colors by remember(theme) {
        derivedStateOf { AppColors.create(theme) }
    }

    KoinContext {
        CompositionLocalProvider(
            LocalColors provides colors,
            LocalDimensions provides dimensions,
            LocalTypography provides typography,
        ) {
            MaterialTheme(
                colorScheme = colors.colorScheme,
                typography = MaterialTypography
            ) {
                content()
            }
        }
    }
}

object AppTheme {
    val colors @Composable get() = LocalColors.current
    val dimensions @Composable get() = LocalDimensions.current
    val typography @Composable get() = LocalTypography.current
}