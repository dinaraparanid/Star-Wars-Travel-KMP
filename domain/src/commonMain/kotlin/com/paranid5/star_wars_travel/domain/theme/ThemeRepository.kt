package com.paranid5.star_wars_travel.domain.theme

import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    val themeFlow: Flow<Theme>
    suspend fun storeTheme(theme: Theme)
}
