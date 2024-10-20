package com.paranid5.star_wars_travel.feature.about_app.component

import com.arkivanov.decompose.ComponentContext
import com.paranid5.star_wars_travel.domain.use_case.OpenBrowserUseCase

internal class AboutAppComponentImpl(
    componentContext: ComponentContext,
    private val openBrowserUseCase: OpenBrowserUseCase,
) : AboutAppComponent, ComponentContext by componentContext {

    private companion object {
        const val MY_GITHUB_URL = "https://github.com/dinaraparanid"
        const val PROJECT_GITHUB_URL = "https://github.com/dinaraparanid/Star-Wars-Travel-KMP"
    }

    override fun onUiIntent(intent: AboutAppUiIntent) {
        when (intent) {
            AboutAppUiIntent.OpenMyGitHub -> openBrowserUseCase.openBrowser(MY_GITHUB_URL)
            AboutAppUiIntent.OpenProjectGitHub -> openBrowserUseCase.openBrowser(PROJECT_GITHUB_URL)
        }
    }

    class Factory(
        private val openBrowserUseCase: OpenBrowserUseCase,
    ) : AboutAppComponent.Factory {
        override fun create(context: ComponentContext): AboutAppComponent =
            AboutAppComponentImpl(
                componentContext = context,
                openBrowserUseCase = openBrowserUseCase,
            )
    }
}
