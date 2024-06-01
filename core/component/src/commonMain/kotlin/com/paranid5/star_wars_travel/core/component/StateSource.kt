package com.paranid5.star_wars_travel.core.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

interface StateSource<State> : ComponentContext {

    val stateFlow: StateFlow<State>
}