package com.burcutopcu.findplacesapp.ui.locationdetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.constants.GeneralConstants
import com.burcutopcu.findplacesapp.constants.IntentKeys
import com.burcutopcu.findplacesapp.models.PlaceResponse
import com.burcutopcu.findplacesapp.ui.locationdetail.di.DaggerLocationDetailActivityComponent
import com.burcutopcu.findplacesapp.ui.locationdetail.vm.LocationDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_location_detail.*
import kotlinx.android.synthetic.main.full_screen_loading.*
import javax.inject.Inject

class LocationDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var locationDetailActivityViewModel: LocationDetailActivityViewModel

    private lateinit var locationId: String
    private lateinit var locationName: String
    private lateinit var currentPlace: PlaceResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_detail)
        DaggerLocationDetailActivityComponent.builder().application(this).build().inject(this)
        if (intent.extras != null) {
            locationId = intent.extras!!.getString(IntentKeys.PLACE_ID)!!
            locationName = intent.extras!!.getString(IntentKeys.PLACE_NAME)!!
        }
        getPlace()
    }

    private fun getPlace() {
        progressLayout.visibility = View.VISIBLE
        locationDetailActivityViewModel.getPlaces(locationName)
            .subscribe({
                it.placeResponses.forEach { place ->
                    if (place.name == locationName) {
                        currentPlace = place
                        locationDetailTitle.text = currentPlace.name
                        if (currentPlace.openingHours != null && currentPlace.openingHours!!.openNow != null && currentPlace.openingHours!!.openNow!!) {
                            locationOpeningNowText.text = getString(R.string.open_now)
                        } else {
                            locationOpeningNowText.text = getString(R.string.closed_now)
                        }

                        Glide.with(this).load(currentPlace.icon)
                            .into(locationDetailIconImage)

                        if (currentPlace.photos != null) {
                            val url =
                                "https://maps.googleapis.com/maps/api/place/photo?maxwidth=200&photoreference=" + currentPlace.photos[0].photo_reference + "&sensor=true&key=" +
                                        GeneralConstants.MAP_KEY
                            Glide.with(this).load(url).into(locationDetailImage)
                        }
                    }
                }
                progressLayout.visibility = View.GONE
            }, {
                Toast.makeText(this, getString(R.string.error_with_details), Toast.LENGTH_LONG)
                    .show()
                it.printStackTrace()
            })
    }
}