package com.hardik.mvidemo.base

interface Reducer<State : Reducer.State, Event : Reducer.Event, Effect : Reducer.Effect> {
    interface State
    interface Event
    interface Effect

    fun reduce(currentState: State, event: Event): Pair<State, Effect?>
}