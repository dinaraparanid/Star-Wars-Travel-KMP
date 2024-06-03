package com.paranid5.star_wars_travel.data

import com.paranid5.star_wars_travel.data.datastore.ThemeDataSource

interface StorageRepository {
    val themeDataSource: ThemeDataSource
}