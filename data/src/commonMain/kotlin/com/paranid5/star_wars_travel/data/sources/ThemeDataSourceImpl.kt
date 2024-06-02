package com.paranid5.star_wars_travel.data.sources

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.paranid5.star_wars_travel.domain.entities.Theme
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

internal class ThemeDataSourceImpl(private val dataStore: DataStore<Preferences>) : ThemeDataSource {
    private companion object {
        private val THEME_URL = intPreferencesKey("theme")
    }

    private val json by lazy { Json { ignoreUnknownKeys = true } }

    override val themeFlow by lazy {
        dataStore.data
            .map { preferences -> preferences[THEME_URL] }
            .map { it ?: 0 }
            .map(Theme.entries::get)
    }

    override suspend fun storeTheme(theme: Theme) {
        dataStore.edit { preferences -> preferences[THEME_URL] = theme.ordinal }
    }
}