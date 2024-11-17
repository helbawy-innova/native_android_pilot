package com.example.pilot_1.configurations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class Cubit<T>(startingState: T) : ViewModel() {
    private val _cubitState = MutableStateFlow<T>(startingState)

    @Composable
    fun observeStates(): State<T> {
        return this._cubitState.collectAsState()
    }

    fun emit(state: T) {
        this._cubitState.value = state
    }
}