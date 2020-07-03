package com.burcutopcu.findplacesapp.ui.mainactivity.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.models.PlaceListResponse
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val placesRepo: PlacesRepo) : ViewModel() {

    fun getPlaces(newText: String, context: Context): Observable<PlaceListResponse> {
        return placesRepo.getPlaces(newText, "tr", context.getString(R.string.map_key))
    }
}