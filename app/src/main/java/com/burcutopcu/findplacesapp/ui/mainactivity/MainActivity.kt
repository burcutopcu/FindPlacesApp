package com.burcutopcu.findplacesapp.ui.mainactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LifecycleOwner
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.constants.IntentKeys
import com.burcutopcu.findplacesapp.extensions.hideKeyboard
import com.burcutopcu.findplacesapp.models.PlaceResponse
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import com.burcutopcu.findplacesapp.ui.locationdetail.LocationDetailActivity
import com.burcutopcu.findplacesapp.ui.mainactivity.adapters.SearchResultsAdapter
import com.burcutopcu.findplacesapp.ui.mainactivity.di.DaggerMainActivityComponent
import com.burcutopcu.findplacesapp.ui.mainactivity.listeners.UpdateMapListener
import com.burcutopcu.findplacesapp.ui.mainactivity.vm.MainActivityViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), OnMapReadyCallback, LifecycleOwner, UpdateMapListener {

    @Inject
    lateinit var placesRepo: PlacesRepo
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var map: GoogleMap
    lateinit var placeId: String
    lateinit var placeName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder().application(this).build().inject(this)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        locationSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                if (!newText.isBlank()) {
                    mainActivityViewModel.getPlaces(newText, this@MainActivity)
                        .subscribe({ placeList ->
                            if (placeList.placeResponses.isEmpty()) {
                                searchResultsRv.visibility = View.GONE
                                emptyViewText.visibility = View.VISIBLE
                            } else {
                                val adapter = SearchResultsAdapter(
                                    placeList.placeResponses,
                                    this@MainActivity
                                )
                                emptyViewText.visibility = View.GONE
                                searchResultsRv.adapter = adapter
                                searchResultsRv.visibility = View.VISIBLE
                            }
                        }, { throwable ->
                            throwable.printStackTrace()
                        })
                } else {
                    searchResultsRv.visibility = View.GONE
                    emptyViewText.visibility = View.GONE
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })

        seeDetailsButton.setOnClickListener {
            map.clear()
            val i = Intent(this, LocationDetailActivity::class.java)
            i.putExtra(IntentKeys.PLACE_ID, placeId)
            i.putExtra(IntentKeys.PLACE_NAME, placeName)
            startActivity(i)
        }

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    override fun onSearchItemClick(location: PlaceResponse) {
        map.clear()
        searchResultsRv.visibility = View.GONE
        placeId = location.placeId!!
        placeName = location.name!!
        seeDetailsButton.visibility = View.VISIBLE
        this.hideKeyboard()
        val latLng = LatLng(
            location.geometry!!.location.lat.toDouble(),
            location.geometry.location.lng.toDouble()
        )
        map.addMarker(MarkerOptions().position(latLng).title(location.name))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
    }
}