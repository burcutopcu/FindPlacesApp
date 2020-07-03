package com.burcutopcu.findplacesapp.models

import com.google.gson.annotations.SerializedName

data class ViewPort (
    @SerializedName("northeast")
    val northeast: Location,
    @SerializedName("southwest")
    val southwest: Location
)