package com.paranid5.star_wars_travel.feature.about_app.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paranid5.star_wars_travel.feature.about_app.component.AboutAppComponent

@Composable
fun AboutAppScreen(
    aboutAppComponent: AboutAppComponent,
    modifier: Modifier = Modifier,
) = Box(modifier) {
    Text("TODO: About App Screen", Modifier.align(Alignment.Center))
}