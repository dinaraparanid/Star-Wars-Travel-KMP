package com.paranid5.star_wars_travel.feature.planets.presentation.views.item

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.falcon
import com.paranid5.star_wars_travel.core.resources.travel
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val ICON_SIZE = 24.dp

@Composable
internal fun TravelButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) = Button(
    modifier = modifier,
    shape = RoundedCornerShape(AppTheme.dimensions.padding.small),
    colors = ButtonDefaults.buttonColors(
        containerColor = AppTheme.colors.starWarsYellow,
        contentColor = AppTheme.colors.starWarsYellow
    ),
    onClick = onClick
) {
    Icon(
        painter = painterResource(Res.drawable.falcon),
        contentDescription = stringResource(Res.string.travel),
        tint = Color.Black,
        modifier = Modifier
            .size(ICON_SIZE)
            .align(Alignment.CenterVertically)
    )

    Spacer(Modifier.width(AppTheme.dimensions.padding.small))

    Text(
        text = stringResource(Res.string.travel),
        modifier = Modifier.align(Alignment.CenterVertically),
        color = Color.Black,
        style = AppTheme.typography.regular,
        fontFamily = FontFamily.SansSerif,
    )
}