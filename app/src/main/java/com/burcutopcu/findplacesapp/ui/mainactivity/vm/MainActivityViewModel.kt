package com.burcutopcu.findplacesapp.ui.mainactivity.vm

import androidx.lifecycle.ViewModel
import com.burcutopcu.findplacesapp.constants.GeneralConstants
import com.burcutopcu.findplacesapp.models.PlaceListResponse
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val placesRepo: PlacesRepo) : ViewModel() {

    fun getPlaces(newText: String): Observable<PlaceListResponse> {
        return placesRepo.getPlaces(newText, GeneralConstants.LANGUAGE)
    }
}