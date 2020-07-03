package com.burcutopcu.findplacesapp.ui.locationdetail.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import javax.inject.Inject

class LocationDetailActivityViewModelFactory @Inject constructor(private val placesRepo: PlacesRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationDetailActivityViewModel::class.java)) {
            return LocationDetailActivityViewModel(placesRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}