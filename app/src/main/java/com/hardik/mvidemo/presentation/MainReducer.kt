package com.hardik.mvidemo.presentation

import com.hardik.mvidemo.base.Reducer

class MainReducer : Reducer<MainReducer.MainState, MainReducer.MainEvent, MainReducer.MainEffect> {

    data class MainState(val count: Int) : Reducer.State

    sealed class MainEvent : Reducer.Event {
        data object Increment : MainEvent()
        data object Decrement : MainEvent()
    }

    sealed class MainEffect : Reducer.Effect {
        data class ShowToast(val message: String) : MainEffect()
    }

    override fun reduce(currentState: MainState, event: MainEvent): Pair<MainState, MainEffect?> {
        when (event) {
            MainEvent.Decrement -> {
                if (currentState.count == 0) {
                    return currentState to MainEffect.ShowToast("Count cannot be negative")
                }

                return currentState.copy(count = currentState.count.dec()) to null

            }

            MainEvent.Increment -> {
                return currentState.copy(count = currentState.count.inc()) to null
            }
        }
    }
}