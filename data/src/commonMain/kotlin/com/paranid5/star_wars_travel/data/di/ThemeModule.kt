package com.paranid5.star_wars_travel.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.paranid5.star_wars_travel.data.sources.ThemeDataSource
import com.paranid5.star_wars_travel.data.sources.ThemeDataSourceImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton

internal val themeModule = DI.Module("themeModule") {
    bind<ThemeDataSource>() with multiton { dataStore: DataStore<Preferences> ->
        ThemeDataSourceImpl(dataStore)
    }
}