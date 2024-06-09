package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.paranid5.star_wars_travel.core.ui.common.BackButton
import com.paranid5.star_wars_travel.core.ui.theme.AppDimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.core.ui.utils.pxToDp
import com.paranid5.star_wars_travel.core.ui.utils.toPx
import com.paranid5.star_wars_travel.feature.planet.component.PlanetState
import com.paranid5.star_wars_travel.feature.planet.component.PlanetUiIntent
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetCover
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.PlanetTitle
import com.paranid5.star_wars_travel.feature.planet.presentation.views.common.TravelButton

private val COVER_MAX_SIZE = 312.dp

internal expect val BIG_COVER_BIG_TOP_BAR_TRANSITION: Dp
internal val BIG_COVER_BIG_TOP_BAR_TRANSITION_PC = COVER_MAX_SIZE / 2
internal val BIG_COVER_BIG_TOP_BAR_TRANSITION_MOBILE = COVER_MAX_SIZE

internal expect val COVER_MIN_SIZE: Dp
internal val COVER_PC_MIN_SIZE_PC = 128.dp
internal val COVER_PC_MIN_SIZE_MOBILE = 128.dp

@Composable
internal fun TopBarCover(
    scrollValue: Float,
    state: PlanetState,
    onUiIntent: (PlanetUiIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val appDimensions = AppTheme.dimensions
    val bigCoverBigTopBarTransition = BIG_COVER_BIG_TOP_BAR_TRANSITION.toPx()
    val coverSize by rememberCoverSize(scrollValue)

    ConstraintLayout(modifier = modifier, animateChanges = true) {
        val (
            title,
            backButton,
            cover,
            travelButton,
        ) = createRefs()

        PlanetCover(
            planet = state.planet,
            modifier = Modifier
                .widthIn(max = coverSize)
                .aspectRatio(1F)
                .clip(
                    coverShape(
                        scrollValue = scrollValue,
                        appCorners = appDimensions.corners,
                    )
                )
                .constrainAs(cover) {
                    coverConstraints(
                        scrollValue = scrollValue,
                        bigCoverBigTopBarTransition = bigCoverBigTopBarTransition,
                        backButton = backButton,
                        appPadding = appDimensions.padding,
                    )
                }
        )

        PlanetTitle(
            planetTitle = state.planet.title,
            style = AppTheme.typography.h.h2,
            modifier = Modifier
                .zIndex(1F)
                .constrainAs(title) {
                    titleConstraints(
                        scrollValue = scrollValue,
                        bigCoverBigTopBarTransition = bigCoverBigTopBarTransition,
                        travelButton = travelButton,
                        cover = cover,
                        appPadding = appDimensions.padding,
                    )
                }
        )

        BackButton(
            onBack = { onUiIntent(PlanetUiIntent.GoBack) },
            modifier = Modifier
                .zIndex(1F)
                .constrainAs(backButton) {
                    top.linkTo(parent.top, margin = appDimensions.padding.extraBig)
                    start.linkTo(parent.start, margin = appDimensions.padding.small)
                }
        )

        TravelButton(
            onClick = { onUiIntent(PlanetUiIntent.ShowTravelSnackbar) },
            modifier = Modifier.constrainAs(travelButton) {
                travelButtonConstraints(
                    scrollValue = scrollValue,
                    bigCoverBigTopBarTransition = bigCoverBigTopBarTransition,
                    cover = cover,
                    appPadding = appDimensions.padding,
                )
            }
        )
    }
}

@Composable
internal expect fun coverShape(
    scrollValue: Float,
    appCorners: AppDimensions.Corners,
): Shape

@Composable
internal fun coverShapePC(scrollValue: Float, appCorners: AppDimensions.Corners) =
    RoundedCornerShape(
        maxOf(appCorners.medium - (scrollValue / 100).toInt().dp, appCorners.small)
    )

@Composable
internal fun coverShapeMobile(
    scrollValue: Float,
    appCorners: AppDimensions.Corners,
): Shape {
    val bigCoverBigTopBarTransition = BIG_COVER_BIG_TOP_BAR_TRANSITION.toPx()
    return when {
        scrollValue < bigCoverBigTopBarTransition -> RectangleShape
        else -> RoundedCornerShape(
            maxOf(appCorners.medium - (scrollValue / 100).toInt().dp, appCorners.small)
        )
    }
}

@Composable
internal expect fun rememberCoverSize(scrollValue: Float): State<Dp>

@Composable
internal fun rememberCoverSizeMobile(scrollValue: Float): State<Dp> {
    val scrollValueDp = scrollValue.toInt().pxToDp()
    val bigCoverBigTopBarTransition = BIG_COVER_BIG_TOP_BAR_TRANSITION.toPx()
    return remember(scrollValueDp, bigCoverBigTopBarTransition) {
        derivedStateOf {
            when {
                scrollValue < bigCoverBigTopBarTransition -> COVER_MAX_SIZE - (scrollValueDp / 2)
                else -> COVER_MIN_SIZE
            }
        }
    }
}

@Composable
internal fun rememberCoverSizePC(scrollValue: Float): State<Dp> {
    val scrollValueDp = scrollValue.toInt().pxToDp()
    return remember(scrollValueDp) {
        derivedStateOf { maxOf(COVER_MAX_SIZE - (scrollValueDp / 2), COVER_MIN_SIZE) }
    }
}

internal expect fun ConstrainScope.coverConstraints(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    backButton: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding,
)

internal fun ConstrainScope.coverConstraintsPC(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    backButton: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding,
) = when {
    scrollValue < bigCoverBigTopBarTransition -> {
        top.linkTo(parent.top, margin = appPadding.extraMedium)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    else -> {
        top.linkTo(parent.top, margin = appPadding.extraMedium)
        bottom.linkTo(parent.bottom, margin = appPadding.extraMedium)
        start.linkTo(backButton.end, margin = appPadding.extraMedium)
    }
}

internal fun ConstrainScope.coverConstraintsMobile(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    backButton: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding,
) = when {
    scrollValue < bigCoverBigTopBarTransition -> {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        width = Dimension.fillToConstraints
    }

    else -> {
        top.linkTo(parent.top, margin = appPadding.extraBig)
        bottom.linkTo(parent.bottom, margin = appPadding.extraMedium)
        start.linkTo(backButton.end, margin = appPadding.extraMedium)
    }
}

private fun ConstrainScope.titleConstraints(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    travelButton: ConstrainedLayoutReference,
    cover: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding,
) = when {
    scrollValue < bigCoverBigTopBarTransition -> {
        bottom.linkTo(travelButton.top, margin = appPadding.small)
        start.linkTo(travelButton.start)
    }

    else -> {
        bottom.linkTo(travelButton.top, margin = appPadding.small)
        start.linkTo(cover.end, margin = appPadding.extraMedium)
    }
}

private fun ConstrainScope.travelButtonConstraints(
    scrollValue: Float,
    bigCoverBigTopBarTransition: Float,
    cover: ConstrainedLayoutReference,
    appPadding: AppDimensions.Padding,
) = when {
    scrollValue < bigCoverBigTopBarTransition -> {
        centerAround(cover.bottom)
        start.linkTo(cover.start, margin = appPadding.large)
        end.linkTo(cover.end, margin = appPadding.large)
        width = Dimension.fillToConstraints
    }

    else -> {
        bottom.linkTo(cover.bottom)
        start.linkTo(cover.end, margin = appPadding.extraMedium)
    }
}