package com.paranid5.star_wars_travel.core.component

import com.arkivanov.decompose.ComponentContext

interface UiIntentHandler<UiIntent> : ComponentContext {
    fun onUiIntent(intent: UiIntent)
}
