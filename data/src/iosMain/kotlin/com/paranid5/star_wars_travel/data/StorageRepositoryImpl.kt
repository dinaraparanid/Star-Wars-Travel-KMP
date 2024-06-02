package com.paranid5.star_wars_travel.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.paranid5.star_wars_travel.data.sources.ThemeDataSource
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

internal class StorageRepositoryImpl(override val di: DI) : StorageRepository, DIAware {
    private companion object {
        const val DATA_STORE_PATH = "params.preferences_pb"

        @OptIn(ExperimentalForeignApi::class)
        fun producePath(): String {
            val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )

            return "${requireNotNull(documentDirectory).path}/$DATA_STORE_PATH"
        }
    }

    private val dataStore by lazy {
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { producePath().toPath() }
        )
    }

    override val themeDataSource: ThemeDataSource by instance(arg = dataStore)
}