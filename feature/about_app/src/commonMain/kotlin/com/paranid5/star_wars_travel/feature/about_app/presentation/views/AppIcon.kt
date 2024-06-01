package com.paranid5.star_wars_travel.feature.about_app.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_icon
import com.paranid5.star_wars_travel.core.resources.app_name
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AppIcon(modifier: Modifier = Modifier) =
    Image(
        painter = painterResource(Res.drawable.app_icon),
        contentDescription = stringResource(Res.string.app_name),
        contentScale = ContentScale.FillBounds,
        modifier = modifier.clip(RoundedCornerShape(AppTheme.dimensions.corners.small))
    )