package com.paranid5.star_wars_travel.feature.about_app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paranid5.star_wars_travel.core.ui.theme.AppTheme
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppDescription1
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppDescription2
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppDeveloper
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppDeveloperLabel
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppIcon
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.AppNameLabel
import com.paranid5.star_wars_travel.feature.about_app.presentation.views.GitHubButton

private val APP_ICON_SIZE = 120.dp

@Composable
fun AboutAppScreen(
    aboutAppComponent: AboutAppComponent,
    modifier: Modifier = Modifier,
) {
    val padding = AppTheme.dimensions.padding

    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(padding.enormous))

        AppIcon(
            Modifier
                .size(APP_ICON_SIZE)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(padding.small))

        AppNameLabel(Modifier.align(Alignment.CenterHorizontally))

        Spacer(Modifier.height(padding.large))

        AppDeveloperLabel(Modifier.align(Alignment.Start))

        Spacer(Modifier.height(padding.small))

        AppDeveloper(
            aboutAppComponent = aboutAppComponent,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(Modifier.height(padding.extraMedium))

        AppDescription1(Modifier.align(Alignment.Start))

        Spacer(Modifier.height(padding.small))

        AppDescription2(Modifier.align(Alignment.Start))

        Spacer(Modifier.height(padding.extraMedium))

        GitHubButton(
            aboutAppComponent = aboutAppComponent,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(Modifier.height(padding.small))
    }
}