package com.burcutopcu.findplacesapp.tests

import com.burcutopcu.findplacesapp.fakes.FakeGlobalGson
import com.burcutopcu.findplacesapp.fakes.FakePlacesResponse
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import com.burcutopcu.findplacesapp.ui.mainactivity.vm.MainActivityViewModel
import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PlacesResponseParserTest {

    private var viewModel: MainActivityViewModel? = null
    private var mFakeInfoModel: FakePlacesResponse? = null
    private var mGson: FakeGlobalGson? = null

    @Mock
    lateinit var placesRepo: PlacesRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mFakeInfoModel = FakePlacesResponse()
        mGson = FakeGlobalGson()
        viewModel = MainActivityViewModel(placesRepo)
    }

    @Test
    fun getPlacesList_ShouldReturnCorrectly() {

        //Given
        val fakeModel = mFakeInfoModel!!.getFakePlacesResponse(mGson!!.getFakeGlobalJson()!!)

//        //When
//        val actual: List<String> = fakeModel.placeResponses
//
//        //Then
//        Assertions.assertThat(actual)
//            .isNotNull()
//            .isNotEmpty()
    }

    @After
    fun tearDown() {
        viewModel = null
        mFakeInfoModel = null
        mGson = null
    }
}