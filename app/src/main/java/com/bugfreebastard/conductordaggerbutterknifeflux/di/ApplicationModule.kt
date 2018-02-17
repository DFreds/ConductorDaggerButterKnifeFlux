package com.bugfreebastard.conductordaggerbutterknifeflux.di

import android.content.Context
import com.bugfreebastard.conductordaggerbutterknifeflux.App
import com.nigelbrown.fluxion.Flux
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App {
        return app
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun providesRxFlux(app: App): Flux {
        return Flux.init(app)
    }

}