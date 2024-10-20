package com.paranid5.star_wars_travel.data.theme

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.paranid5.star_wars_travel.domain.entities.Theme
import com.paranid5.star_wars_travel.domain.theme.ThemeRepository
import kotlinx.coroutines.flow.map

internal class ThemeRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
) : ThemeRepository {
    private companion object {
        private val ThemeUrl = intPreferencesKey("theme")
    }

    override val themeFlow by lazy {
        dataStore.data
            .map { preferences -> preferences[ThemeUrl] }
            .map { it ?: 0 }
            .map { Theme.entries.getOrNull(it) ?: Theme.DARK }
    }

    override suspend fun storeTheme(theme: Theme) {
        dataStore.edit { preferences -> preferences[ThemeUrl] = theme.ordinal }
    }
}
