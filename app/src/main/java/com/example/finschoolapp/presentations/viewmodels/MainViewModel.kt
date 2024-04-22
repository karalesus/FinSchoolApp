package com.example.finschoolapp.presentations.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val privateMainState = MutableLiveData<String>()
    val mainState: LiveData<String> get() = privateMainState

    fun updateMainState(newState: String) {
        privateMainState.value = newState
    }
}