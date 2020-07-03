package com.burcutopcu.findplacesapp.models

import com.google.gson.annotations.SerializedName

class PlaceResponse(
    @SerializedName("geometry")
    val geometry: Geometry?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("opening_hours")
    val openingHours: OpeningHours?,
    @SerializedName("photos")
    val photos: ArrayList<Photos>,
    @SerializedName("place_id")
    val placeId: String?,
    @SerializedName("reference")
    val reference: String?,
    @SerializedName("types")
    val types: ArrayList<String>?,
    @SerializedName("vicinity")
    val vicinity: String?
)