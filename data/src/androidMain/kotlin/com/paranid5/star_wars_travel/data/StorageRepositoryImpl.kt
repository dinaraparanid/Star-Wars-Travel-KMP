package com.paranid5.star_wars_travel.data

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.paranid5.star_wars_travel.data.sources.ThemeDataSource
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

internal class StorageRepositoryImpl(context: Context) : StorageRepository, DIAware {
    private val Context.dataStore by preferencesDataStore("params")
    private val dataStore = context.dataStore

    override val di: DI by closestDI(context)
    override val themeDataSource: ThemeDataSource by instance(arg = dataStore)
}