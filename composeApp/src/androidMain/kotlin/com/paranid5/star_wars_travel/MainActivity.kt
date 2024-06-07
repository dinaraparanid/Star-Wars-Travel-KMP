package com.paranid5.star_wars_travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.paranid5.star_wars_travel.component.root.RootComponent
import com.paranid5.star_wars_travel.presentation.App
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class MainActivity : ComponentActivity(), DIAware {
    override val di: DI by closestDI()
    private val rootComponentFactory: RootComponent.Factory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootComponent = rootComponentFactory.create(defaultComponentContext())

        setContent {
            App(
                rootComponent = rootComponent,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}