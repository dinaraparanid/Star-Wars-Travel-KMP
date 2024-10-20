package com.paranid5.star_wars_travel.feature.planet.presentation.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.falcon
import com.paranid5.star_wars_travel.core.resources.travel
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButton
import com.paranid5.star_wars_travel.core.ui.foundation.adaptive.AdaptiveButtonColors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val IconSize = 24.dp

@Composable
fun TravelButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = AdaptiveButton(
    modifier = modifier,
    shape = RoundedCornerShape(dimensions.padding.small),
    colors = AdaptiveButtonColors(backgroundColor = colors.primary),
    onClick = onClick,
) {
    Icon(
        painter = painterResource(Res.drawable.falcon),
        contentDescription = stringResource(Res.string.travel),
        tint = colors.text.onButton,
        modifier = Modifier
            .size(IconSize)
            .align(Alignment.CenterVertically),
    )

    Spacer(Modifier.width(dimensions.padding.small))

    Text(
        text = stringResource(Res.string.travel),
        modifier = Modifier.align(Alignment.CenterVertically),
        color = colors.text.onButton,
        style = typography.regular,
        fontFamily = FontFamily.SansSerif,
    )
}
