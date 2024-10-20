package com.paranid5.star_wars_travel.core.ui.foundation.adaptive

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import io.github.alexzhirkevich.cupertino.CupertinoBottomAppBar
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveWidget
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@OptIn(ExperimentalAdaptiveApi::class, ExperimentalCupertinoApi::class)
@Composable
fun AdaptiveBottomAppBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val background = colors.appBar.background

    val barModifier = Modifier.clip(
        RoundedCornerShape(
            topStart = dimensions.corners.medium,
            topEnd = dimensions.corners.medium,
        )
    ) then modifier

    AdaptiveWidget(
        material = {
            BottomAppBar(
                containerColor = background,
                modifier = barModifier,
                content = content,
            )
        },
        cupertino = {
            CupertinoBottomAppBar(
                containerColor = background,
                modifier = barModifier,
                content = content,
            )
        },
    )
}
