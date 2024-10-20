package com.paranid5.star_wars_travel.feature.about_app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme.dimensions
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppDescription1
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppDescription2
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppDeveloper
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppDeveloperLabel
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppIcon
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.AppNameLabel
import com.paranid5.star_wars_travel.feature.about_app.presentation.ui.GitHubButton

private val AppIconSize = 120.dp
private val Description2MaxWidth = 512.dp

@Composable
fun AboutAppScreen(
    aboutAppComponent: AboutAppComponent,
    modifier: Modifier = Modifier,
) {
    val onUiIntent = aboutAppComponent::onUiIntent

    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(dimensions.padding.enormous))

        AppIcon(
            Modifier
                .size(AppIconSize)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(dimensions.padding.small))

        AppNameLabel(Modifier.align(Alignment.CenterHorizontally))

        Spacer(Modifier.height(dimensions.padding.small))

        AppDeveloperLabel(Modifier.align(Alignment.CenterHorizontally))

        Spacer(Modifier.height(dimensions.padding.small))

        AppDeveloper(
            onUiIntent = onUiIntent,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(dimensions.padding.big))

        AppDescription1(Modifier.align(Alignment.CenterHorizontally))

        AppDescription2(
            Modifier
                .widthIn(max = Description2MaxWidth)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(dimensions.padding.large))

        GitHubButton(
            onUiIntent = onUiIntent,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(Modifier.height(dimensions.padding.small))
    }
}
