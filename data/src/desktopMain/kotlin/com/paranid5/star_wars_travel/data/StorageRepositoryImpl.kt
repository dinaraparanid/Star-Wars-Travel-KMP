package com.paranid5.star_wars_travel.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import okio.Path.Companion.toPath

internal class StorageRepositoryImpl : StorageRepository {
    private companion object {
        const val DATA_STORE_PATH = "params.preferences_pb"
    }

    override val dataStore by lazy {
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { DATA_STORE_PATH.toPath() }
        )
    }
}
