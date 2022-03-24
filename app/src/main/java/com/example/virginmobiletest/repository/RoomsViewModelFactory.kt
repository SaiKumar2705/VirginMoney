package com.example.virginmobiletest.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RoomsViewModelFactory constructor(private val repository: ApiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RoomsViewModel::class.java)) {
            RoomsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}