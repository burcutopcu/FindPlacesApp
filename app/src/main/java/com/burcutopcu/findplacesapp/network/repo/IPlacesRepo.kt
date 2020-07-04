package com.burcutopcu.findplacesapp.network.repo

import com.burcutopcu.findplacesapp.models.PlaceListResponse
import io.reactivex.Observable

interface IPlacesRepo {
    fun getPlaces(
        query: String,
        language: String
    ): Observable<PlaceListResponse>
}