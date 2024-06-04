package com.paranid5.star_wars_travel.feature.planets.presentation.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.State
import com.paranid5.star_wars_travel.feature.planets.component.PlanetsStore.UiIntent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private val ICON_SIZE = 20.dp

@Composable
internal fun PlanetsSearchBar(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    BasicTextField(
        value = state.searchText,
        singleLine = true,
        onValueChange = { onUiIntent(UiIntent.UpdateSearchText(text = it)) },
        textStyle = AppTheme.typography.regular.copy(color = AppTheme.colors.onBackground),
        modifier = modifier
            .clip(RoundedCornerShape(AppTheme.dimensions.corners.medium))
            .border(
                width = AppTheme.dimensions.separators.minimum,
                color = AppTheme.colors.transparentUtility,
                shape = RoundedCornerShape(AppTheme.dimensions.corners.medium)
            ),
        decorationBox = {
            SearchDecorBox(
                state = state,
                onUiIntent = onUiIntent,
                innerTextField = it,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchDecorBox(
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    innerTextField: @Composable () -> Unit,
) {
    val colors = AppTheme.colors
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
                modifier = Modifier.size(ICON_SIZE),
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = colors.onBackground,
            unfocusedTextColor = colors.onBackground,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = colors.starWarsYellow.copy(alpha = 0.1F),
            unfocusedContainerColor = colors.starWarsYellow.copy(alpha = 0.1F)
        ),
        placeholder = { Placeholder() }
    )
}

@Composable
private fun SearchIcon(modifier: Modifier = Modifier) {
    Row(modifier) {
        Icon(
            painter = painterResource(Res.drawable.search),
            contentDescription = stringResource(Res.string.search),
            tint = AppTheme.colors.onBackground,
            modifier = Modifier.size(ICON_SIZE)
        )

        Spacer(Modifier.width(AppTheme.dimensions.padding.small))
    }
}

@Composable
private fun CancelIcon(
    isFocused: Boolean,
    state: State,
    onUiIntent: (UiIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = AppTheme.colors

    val isIconActive by remember(state.searchText, isFocused) {
        derivedStateOf { state.searchText.isNotEmpty() || isFocused }
    }

    val iconColor by remember(isIconActive) {
        derivedStateOf { if (isIconActive) colors.onBackground else Color.Transparent }
    }

    Icon(
        painter = painterResource(Res.drawable.cross),
        contentDescription = stringResource(Res.string.cancel_search),
        tint = iconColor,
        modifier = modifier.clickable(enabled = isIconActive) {
            onUiIntent(UiIntent.UpdateSearchText(""))
        }
    )
}

@Composable
private fun Placeholder(modifier: Modifier = Modifier) =
    Text(
        text = stringResource(Res.string.enter_planet),
        style = AppTheme.typography.regular,
        modifier = modifier,
    )