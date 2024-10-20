package com.paranid5.star_wars_travel.feature.planets.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.cancel_search
import com.paranid5.star_wars_travel.core.resources.cross
import com.paranid5.star_wars_travel.core.resources.enter_planet
import com.paranid5.star_wars_travel.core.resources.search
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import com.paranid5.star_wars_travel.core.ui.utils.clickableWithRipple
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val IconSize = 20.dp

@Composable
internal fun PlanetsSearchBar(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) = BasicTextField(
    value = state.searchText,
    singleLine = true,
    onValueChange = { onUiIntent(UiIntent.UpdateSearchText(text = it)) },
    textStyle = typography.regular.copy(color = colors.text.primary),
    modifier = modifier
        .clip(RoundedCornerShape(dimensions.corners.medium))
        .border(
            width = dimensions.separators.minimum,
            color = colors.transparentUtility,
            shape = RoundedCornerShape(dimensions.corners.medium),
        ),
    decorationBox = {
        SearchDecorBox(
            state = state,
            onUiIntent = onUiIntent,
            innerTextField = it,
        )
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchDecorBox(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    innerTextField: @Composable () -> Unit,
) {
    val interactionSrc = remember { MutableInteractionSource() }
    val isFocused by interactionSrc.collectIsFocusedAsState()

    TextFieldDefaults.DecorationBox(
        value = state.searchText,
        innerTextField = innerTextField,
        enabled = true,
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSrc,
        prefix = { SearchIcon() },
        suffix = {
            CancelIcon(
                isFocused = isFocused,
                state = state,
                onUiIntent = onUiIntent,
                modifier = Modifier.size(IconSize),
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = colors.text.primary,
            unfocusedTextColor = colors.text.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = colors.primary.copy(alpha = 0.1F),
            unfocusedContainerColor = colors.primary.copy(alpha = 0.1F)
        ),
        placeholder = { Placeholder() }
    )
}

@Composable
private fun SearchIcon(modifier: Modifier = Modifier) = Row(modifier) {
    Icon(
        painter = painterResource(Res.drawable.search),
        contentDescription = stringResource(Res.string.search),
        tint = colors.text.primary,
        modifier = Modifier.size(IconSize)
    )

    Spacer(Modifier.width(dimensions.padding.small))
}

@Composable
private fun CancelIcon(
    isFocused: Boolean,
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = colors

    val isIconActive by remember(state.searchText, isFocused) {
        derivedStateOf { state.searchText.isNotEmpty() || isFocused }
    }

    AnimatedVisibility(
        visible = isIconActive,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Icon(
            painter = painterResource(Res.drawable.cross),
            contentDescription = stringResource(Res.string.cancel_search),
            tint = colors.text.primary,
            modifier = modifier.clickableWithRipple {
                onUiIntent(UiIntent.UpdateSearchText(""))
            }
        )
    }
}

@Composable
private fun Placeholder(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.enter_planet),
        style = typography.regular,
        color = colors.text.placeholder,
        modifier = modifier,
    )
