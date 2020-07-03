package com.burcutopcu.findplacesapp.ui.locationdetail.vm

import androidx.lifecycle.ViewModel
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import javax.inject.Inject

class LocationDetailActivityViewModel @Inject constructor(private val placesRepo: PlacesRepo) : ViewModel() {

    fun getPlaceDetails(locationId: String) {

    }
}