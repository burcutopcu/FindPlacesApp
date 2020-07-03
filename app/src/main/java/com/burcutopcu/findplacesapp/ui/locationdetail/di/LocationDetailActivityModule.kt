package com.burcutopcu.findplacesapp.ui.locationdetail.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.burcutopcu.findplacesapp.app.AppManager
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import com.burcutopcu.findplacesapp.ui.locationdetail.LocationDetailActivity
import com.burcutopcu.findplacesapp.ui.locationdetail.vm.LocationDetailActivityViewModel
import com.burcutopcu.findplacesapp.ui.locationdetail.vm.LocationDetailActivityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LocationDetailActivityModule::class])
    abstract fun bindLocationDetailActivity(): LocationDetailActivity
}

@Module
class LocationDetailActivityModule {

    @Provides
    @Singleton
    fun provideLocationDetailViewModel(
        activity: LocationDetailActivity,
        factory: LocationDetailActivityViewModelFactory
    ): LocationDetailActivityViewModel {
        return ViewModelProviders.of(activity, factory)
            .get(LocationDetailActivityViewModel::class.java)
    }

    @Provides
    @Singleton
    fun getRepository(apiManager: AppManager): PlacesRepo {
        return PlacesRepo(apiManager)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(placesRepo: PlacesRepo): ViewModelProvider.Factory {
        return LocationDetailActivityViewModelFactory(placesRepo)
    }
}