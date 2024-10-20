package com.paranid5.star_wars_travel.core.ui.foundation.adaptive

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import io.github.alexzhirkevich.cupertino.CupertinoButton
import io.github.alexzhirkevich.cupertino.CupertinoButtonDefaults
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveWidget
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi

@Immutable
data class AdaptiveButtonColors(
    val backgroundColor: Color = Color.Unspecified,
    val contentColor: Color = Color.Unspecified,
    val disabledBackgroundColor: Color = Color.Unspecified,
    val disabledContentColor: Color = Color.Unspecified,
)

@OptIn(ExperimentalAdaptiveApi::class, ExperimentalCupertinoApi::class)
@Composable
fun AdaptiveButton(
    onClick: () -> Unit,
    shape: Shape,
    colors: AdaptiveButtonColors,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    content: @Composable RowScope.() -> Unit,
) = AdaptiveWidget(
    material = {
        Button(
            modifier = modifier,
            shape = shape,
            enabled = enabled,
            elevation = elevation,
            border = border,
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.backgroundColor,
                disabledContainerColor = colors.disabledBackgroundColor,
                contentColor = colors.contentColor,
                disabledContentColor = colors.disabledContentColor,
            ),
            onClick = onClick,
            content = content,
        )
    },
    cupertino = {
        CupertinoButton(
            modifier = modifier,
            shape = shape,
            enabled = enabled,
            border = border,
            colors = CupertinoButtonDefaults.filledButtonColors(
                containerColor = colors.backgroundColor,
                disabledContainerColor = colors.disabledBackgroundColor,
                contentColor = colors.contentColor,
                disabledContentColor = colors.disabledContentColor,
            ),
            onClick = onClick,
            content = content,
        )
    }
)
