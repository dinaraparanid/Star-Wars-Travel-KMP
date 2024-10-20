package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.data.theme.ThemeRepositoryImpl
import com.paranid5.star_wars_travel.domain.theme.ThemeRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.multiton

internal val themeModule = DI.Module("themeModule") {
    bind<ThemeRepository>() with multiton {
        val storageRepository by di.instance<StorageRepository>()
        ThemeRepositoryImpl(dataStore = storageRepository.dataStore)
    }
}
