package com.paranid5.star_wars_travel.data

import com.paranid5.star_wars_travel.data.sources.ThemeDataSource

interface StorageRepository {
    val themeDataSource: ThemeDataSource
}