package com.burcutopcu.findplacesapp.ui.locationdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.ui.locationdetail.di.DaggerLocationDetailActivityComponent
import com.burcutopcu.findplacesapp.ui.locationdetail.vm.LocationDetailActivityViewModel
import javax.inject.Inject

class LocationDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var locationDetailActivityViewModel: LocationDetailActivityViewModel

    lateinit var locationId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_detail)
        DaggerLocationDetailActivityComponent.builder().application(this).build().inject(this)

        if (intent.extras != null) {
            locationId = intent.extras!!.getString("location_id")!!
        }

        locationDetailActivityViewModel.getPlaceDetails(locationId)

    }
}