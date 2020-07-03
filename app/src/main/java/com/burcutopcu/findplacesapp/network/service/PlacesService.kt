package com.burcutopcu.findplacesapp.network.service

import com.burcutopcu.findplacesapp.models.PlaceListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesService {
    @GET("place/textsearch/json")
    fun getPlaces(
    @Query("query") input: String,
    @Query("language") language: String,
    @Query("key") key: String): Observable<PlaceListResponse>
}