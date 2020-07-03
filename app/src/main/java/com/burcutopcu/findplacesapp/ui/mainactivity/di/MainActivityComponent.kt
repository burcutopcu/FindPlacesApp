package com.burcutopcu.findplacesapp.ui.mainactivity.di

import com.burcutopcu.findplacesapp.app.FindPlacesApplicationModule
import com.burcutopcu.findplacesapp.ui.mainactivity.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [FindPlacesApplicationModule::class, AndroidInjectionModule::class, ActivityBuilder::class])
interface MainActivityComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(activity: MainActivity): Builder

        fun build(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}