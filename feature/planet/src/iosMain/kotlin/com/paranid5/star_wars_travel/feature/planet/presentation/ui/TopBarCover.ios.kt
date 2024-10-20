package com.paranid5.star_wars_travel.feature.planet.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import com.paranid5.star_wars_travel.core.ui.theme.AppDimensions

internal actual val BigCoverBigTopBarTransition = BigCoverBigTopBarTransitionMobile
internal actual val CoverMinSize = CoverMinSizeMobile

internal actual fun ConstrainScope.coverConstraints(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    backButton: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding
) = coverConstraintsMobile(
    scrollValue = scrollValue,
    bigCoverBigTopBarTransition = bigCoverBigTopBarTransition,
    backButton = backButton,
    appPadding = appPadding,
)

@Composable
internal actual fun coverShape(
    scrollValue: Float,
    appCorners: AppDimensions.Corners
): Shape = coverShapeMobile(
    scrollValue = scrollValue,
    appCorners = appCorners,
)

@Composable
internal actual fun rememberCoverSize(scrollValue: Float) =
    rememberCoverSizeMobile(scrollValue)
