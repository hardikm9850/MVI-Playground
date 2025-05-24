package com.hardik.mvidemo.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val mainReducer = MainReducer()
    private val _uiState = MutableStateFlow(MainReducer.MainState(0))
    val uiState: StateFlow<MainReducer.MainState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<MainReducer.MainEffect>(extraBufferCapacity = 1)
    val effect: SharedFlow<MainReducer.MainEffect> = _effect.asSharedFlow()


    fun onAction(event: MainReducer.MainEvent) {
        val (newState, sideEffect) = mainReducer.reduce(_uiState.value, event)
        if (newState.count != _uiState.value.count) {
            _uiState.value = newState
        }
        sideEffect?.let { effect ->
            _effect.tryEmit(effect)
        }
    }
}