package com.paranid5.star_wars_travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.data.StorageRepository
import com.paranid5.star_wars_travel.presentation.App
import platform.UIKit.UIViewController

fun MainViewController(
    rootComponent: RootComponent,
    storageRepository: StorageRepository,
): UIViewController =
    ComposeUIViewController {
        App(
            rootComponent = rootComponent,
            storageRepository = storageRepository,
            modifier = Modifier.fillMaxSize()
        )
    }
