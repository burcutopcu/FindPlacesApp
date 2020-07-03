package com.burcutopcu.findplacesapp.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FindPlacesApplicationModule {
    @Provides
    @Singleton
    fun provideApplication(app: FindPlacesApplication): Context = app

    @Singleton
    @Provides
    fun provideApp(): FindPlacesApplication {
        return FindPlacesApplication()
    }

    @Singleton
    @Provides
    fun provideApiManager(): AppManager {
        return AppManager()
    }
}