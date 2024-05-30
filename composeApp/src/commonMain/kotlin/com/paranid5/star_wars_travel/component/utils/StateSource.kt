package com.paranid5.star_wars_travel.component.utils

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

interface StateSource<State> : ComponentContext {

    val stateFlow: StateFlow<State>
}