package com.paranid5.star_wars_travel.presentation.appbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.about_app
import com.paranid5.star_wars_travel.core.resources.planet
import com.paranid5.star_wars_travel.core.resources.planets
import com.paranid5.star_wars_travel.core.resources.question
import com.paranid5.star_wars_travel.core.resources.settings

@Composable
internal fun AppBar(modifier: Modifier = Modifier) =
    BottomAppBar(
        containerColor = AppTheme.colors.appBarColor,
        modifier = modifier.clip(
            RoundedCornerShape(
                topStart = AppTheme.dimensions.corners.medium,
                topEnd = AppTheme.dimensions.corners.medium
            )
        )
    ) {
        AppBarItem(
            title = stringResource(Res.string.planets),
            image = painterResource(Res.drawable.planet),
            //screen = RootConfig.Planets,
            modifier = Modifier.weight(1F),
            //screenMatches = { it is RootConfig.Planets || it is RootConfig.Planet }
        )

        AppBarItem(
            title = stringResource(Res.string.settings),
            image = painterResource(Res.drawable.settings),
            //screen = RootConfig.Settings,
            modifier = Modifier.weight(1F)
        )

        AppBarItem(
            title = stringResource(Res.string.about_app),
            image = painterResource(Res.drawable.question),
            //screen = RootConfig.AboutApp,
            modifier = Modifier.weight(1F)
        )
    }