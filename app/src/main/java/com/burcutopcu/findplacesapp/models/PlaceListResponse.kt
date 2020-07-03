package com.burcutopcu.findplacesapp.models

import com.google.gson.annotations.SerializedName

data class PlaceListResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("results")
    val placeResponses: List<PlaceResponse>,
    @SerializedName("error_message")
    val errorMessage: String?
)