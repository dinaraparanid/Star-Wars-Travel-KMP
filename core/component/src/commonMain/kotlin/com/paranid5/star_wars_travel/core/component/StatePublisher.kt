package com.paranid5.star_wars_travel.core.component

interface StatePublisher<State> {
    fun updateState(func: State.() -> State)
}
