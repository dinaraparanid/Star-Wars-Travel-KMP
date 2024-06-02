package com.paranid5.star_wars_travel.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.paranid5.star_wars_travel.data.sources.ThemeDataSource
import okio.Path.Companion.toPath
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

internal class StorageRepositoryImpl(override val di: DI) : StorageRepository, DIAware {
    private companion object {
        const val DATA_STORE_PATH = "params.preferences_pb"
    }

    private val dataStore by lazy {
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { DATA_STORE_PATH.toPath() }
        )
    }

    override val themeDataSource: ThemeDataSource by instance(arg = dataStore)
}