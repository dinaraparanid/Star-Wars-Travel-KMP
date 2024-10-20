package com.paranid5.star_wars_travel.core.ui.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme

@Composable
fun Modifier.clickableWithRipple(
    bounded: Boolean = false,
    enabled: Boolean = true,
    color: Color = AppTheme.colors.primary,
    onClick: () -> Unit,
) = this.clickable(
    enabled = enabled,
    interactionSource = remember { MutableInteractionSource() },
    indication = rememberRipple(bounded = bounded, color = color),
    onClick = onClick,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.combinedClickableWithRipple(
    bounded: Boolean = false,
    enabled: Boolean = true,
    color: Color = AppTheme.colors.primary,
    onLongClick: () -> Unit,
    onClick: () -> Unit,
) = this.combinedClickable(
    enabled = enabled,
    interactionSource = remember { MutableInteractionSource() },
    indication = rememberRipple(bounded = bounded, color = color),
    onClick = onClick,
    onLongClick = onLongClick,
)
