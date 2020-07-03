package com.burcutopcu.findplacesapp.models

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("height")
    val height: Int,
    @SerializedName("html_attributions")
    val html_attributions: ArrayList<String>,
    @SerializedName("photo_reference")
    val photo_reference: String,
    @SerializedName("width")
    val width: Int
)