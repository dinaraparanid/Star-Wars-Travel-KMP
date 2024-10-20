package com.paranid5.star_wars_travel.feature.about_app.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.app_name
import com.paranid5.star_wars_travel.core.ui.StarJediFont
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.colors
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.typography
import org.jetbrains.compose.resources.stringResource

private const val MaxLines = 1

@Composable
internal fun AppNameLabel(modifier: Modifier = Modifier) {
    val typo = typography

    var textSize by remember {
        mutableStateOf(typo.h.h1.fontSize)
    }

    Text(
        text = stringResource(Res.string.app_name),
        style = typo.h.h1.copy(fontSize = textSize),
        fontFamily = StarJediFont,
        color = colors.text.primary,
        modifier = modifier,
        onTextLayout = { res ->
            if (res.lineCount > MaxLines)
                textSize = (textSize.value - 1.0).sp
        }
    )
}
