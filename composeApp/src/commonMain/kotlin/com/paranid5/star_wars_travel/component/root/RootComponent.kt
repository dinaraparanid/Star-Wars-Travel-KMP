package com.paranid5.star_wars_travel.component.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.paranid5.star_wars_travel.core.component.StateSource
import com.paranid5.star_wars_travel.core.component.UiIntentHandler

interface RootComponent :
    ComponentContext,
    StateSource<RootState>,
    UiIntentHandler<RootUiIntent> {
    val stack: Value<ChildStack<RootConfig, RootChild>>

    interface Factory {
        fun create(componentContext: ComponentContext): RootComponent
    }
}