package com.burcutopcu.findplacesapp.network.repo

import com.burcutopcu.findplacesapp.app.AppManager
import com.burcutopcu.findplacesapp.models.PlaceListResponse
import com.burcutopcu.findplacesapp.network.service.PlacesService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PlacesRepo @Inject constructor(appManager: AppManager) : IPlacesRepo {

    private var placesService = appManager.createRetrofitService(PlacesService::class.java)

    override fun getPlaces(
        query: String,
        language: String,
        key: String
    ): Observable<PlaceListResponse> {
        return placesService.getPlaces(query, language, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}