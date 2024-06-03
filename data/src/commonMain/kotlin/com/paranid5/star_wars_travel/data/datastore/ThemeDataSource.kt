package com.paranid5.star_wars_travel.data.datastore

import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeDataSource {
    val themeFlow: Flow<Theme>

    suspend fun storeTheme(theme: Theme)
}