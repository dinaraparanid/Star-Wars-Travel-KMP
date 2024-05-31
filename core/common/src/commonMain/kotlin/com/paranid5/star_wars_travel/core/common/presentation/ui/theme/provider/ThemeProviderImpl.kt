package com.paranid5.star_wars_travel.core.common.presentation.ui.theme.provider

import com.paranid5.star_wars_travel.core.common.presentation.ui.theme.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class ThemeProviderImpl : ThemeProvider {
    private val _themeState by lazy {
        MutableStateFlow(Theme.DARK)
    }

    override val themeState by lazy {
        _themeState.asStateFlow()
    }

    override fun setTheme(theme: Theme) =
        _themeState.update { theme }
}