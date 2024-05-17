package com.example.finschoolapp.presentations.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isNavigationBarVisible = MutableLiveData(false)
    val isNavigationBarVisible: LiveData<Boolean> get() = _isNavigationBarVisible

    fun setNavigationBarVisibility(isVisible: Boolean) {
        _isNavigationBarVisible.value = isVisible
    }
}