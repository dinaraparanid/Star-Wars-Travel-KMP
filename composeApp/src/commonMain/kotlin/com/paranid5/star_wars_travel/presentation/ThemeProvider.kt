package com.paranid5.star_wars_travel.presentation

import kotlinx.coroutines.flow.StateFlow

interface ThemeProvider {
    val themeState: StateFlow<Theme>

    fun setTheme(theme: Theme)
}