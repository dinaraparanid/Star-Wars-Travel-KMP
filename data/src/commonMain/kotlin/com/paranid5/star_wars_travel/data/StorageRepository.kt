package com.paranid5.star_wars_travel.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

internal interface StorageRepository {
    val dataStore: DataStore<Preferences>
}
