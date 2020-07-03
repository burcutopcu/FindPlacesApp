package com.burcutopcu.findplacesapp.ui.mainactivity.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(private val placesRepo: PlacesRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(placesRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}