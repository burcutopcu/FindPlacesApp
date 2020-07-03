package com.burcutopcu.findplacesapp.ui.locationdetail.di

import com.burcutopcu.findplacesapp.app.FindPlacesApplicationModule
import com.burcutopcu.findplacesapp.ui.locationdetail.LocationDetailActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [FindPlacesApplicationModule::class, AndroidInjectionModule::class, ActivityBuilder::class])
interface LocationDetailActivityComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(activity: LocationDetailActivity): Builder
        fun build(): LocationDetailActivityComponent
    }

    fun inject(activity: LocationDetailActivity)
}