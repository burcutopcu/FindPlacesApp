package com.burcutopcu.findplacesapp.ui.mainactivity.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.burcutopcu.findplacesapp.app.AppManager
import com.burcutopcu.findplacesapp.ui.mainactivity.MainActivity
import com.burcutopcu.findplacesapp.ui.mainactivity.vm.MainActivityViewModel
import com.burcutopcu.findplacesapp.ui.mainactivity.vm.MainActivityViewModelFactory
import com.burcutopcu.findplacesapp.network.repo.PlacesRepo
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}

@Module
class MainActivityModule {

    @Provides
    @Singleton
    fun provideMainViewModel(
        activity: MainActivity,
        factory: MainActivityViewModelFactory
    ): MainActivityViewModel {
        return ViewModelProviders.of(activity, factory).get(MainActivityViewModel::class.java)
    }

    @Provides
    @Singleton
    fun getRepository(apiManager: AppManager): PlacesRepo {
        return PlacesRepo(apiManager)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(placesRepo: PlacesRepo): ViewModelProvider.Factory {
        return MainActivityViewModelFactory(placesRepo)
    }
}