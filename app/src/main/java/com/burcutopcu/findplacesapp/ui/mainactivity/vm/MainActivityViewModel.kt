package com.burcutopcu.findplacesapp.ui.mainactivity.vm

import android.content.Context
import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.models.PlaceListResponse
import com.burcutopcu.findplacesapp.models.PlaceResponse
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import io.reactivex.Observable
import java.io.IOException
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val placesRepo: PlacesRepo) : ViewModel() {

    var applyMapLiveData : MutableLiveData<PlaceResponse> = MutableLiveData()

    fun getPlaces(newText: String, context: Context): Observable<PlaceListResponse> {
        return placesRepo.getPlaces(newText, "tr", context.getString(R.string.map_key))
    }

    fun goLocation(location: PlaceResponse) {
        if (location.name != "") {
            applyMapLiveData.value = location
        }
    }
}