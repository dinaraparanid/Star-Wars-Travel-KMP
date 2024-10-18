package com.paranid5.star_wars_travel.data

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

internal class StorageRepositoryImpl(context: Context) : StorageRepository {
    private val Context.dataStore by preferencesDataStore("params")
    override val dataStore = context.dataStore
}