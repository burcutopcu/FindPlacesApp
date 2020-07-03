package com.burcutopcu.findplacesapp.models

import com.google.gson.annotations.SerializedName

class Geometry (
    @SerializedName("location")
    val location: Location
)