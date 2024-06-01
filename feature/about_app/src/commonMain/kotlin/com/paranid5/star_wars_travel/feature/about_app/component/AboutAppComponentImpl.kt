package com.paranid5.star_wars_travel.feature.about_app.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.core.common.utils.openBrowser

internal class AboutAppComponentImpl(componentContext: ComponentContext) :
    AboutAppComponent,
    ComponentContext by componentContext {
    private companion object {
        const val MY_GITHUB_URL = "https://github.com/dinaraparanid"
        const val PROJECT_GITHUB_URL = "https://github.com/dinaraparanid/Star-Wars-Travel-KMP"
    }

    override fun onUiIntent(intent: AboutAppUiIntent) {
        when (intent) {
            AboutAppUiIntent.OpenMyGitHub -> openBrowser(MY_GITHUB_URL)
            AboutAppUiIntent.OpenProjectGitHub -> openBrowser(PROJECT_GITHUB_URL)
        }
    }

    class Factory : AboutAppComponent.Factory {
        override fun create(context: ComponentContext): AboutAppComponent =
            AboutAppComponentImpl(context)
    }
}
