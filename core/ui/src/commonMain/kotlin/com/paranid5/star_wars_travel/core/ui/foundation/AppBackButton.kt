package com.paranid5.star_wars_travel.core.ui.foundation

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveIconButton
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.icons.AdaptiveIcons
import io.github.alexzhirkevich.cupertino.icons.CupertinoIcons
import io.github.alexzhirkevich.cupertino.icons.outlined.ChevronBackward

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun AppBackButton(modifier: Modifier = Modifier, onBack: () -> Unit) =
    AdaptiveIconButton(modifier = modifier, onClick = onBack) {
        Icon(
            imageVector = AdaptiveIcons.vector(
                material = { Icons.AutoMirrored.Filled.ArrowBack },
                cupertino = { CupertinoIcons.Outlined.ChevronBackward },
            ),
            contentDescription = null,
            tint = colors.primary,
        )
    }
