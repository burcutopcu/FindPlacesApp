package com.burcutopcu.findplacesapp.ui.mainactivity.listeners

import com.burcutopcu.findplacesapp.models.PlaceResponse

interface UpdateMapListener {
    fun onSearchItemClick(location: PlaceResponse)
}