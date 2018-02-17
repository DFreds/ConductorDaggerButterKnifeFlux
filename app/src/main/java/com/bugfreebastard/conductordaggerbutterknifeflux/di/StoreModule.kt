package com.bugfreebastard.conductordaggerbutterknifeflux.di

import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeStore
import com.nigelbrown.fluxion.Flux
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class StoreModule {
    @Provides
    @Singleton
    internal fun provideHomeStore(flux: Flux): HomeStore {
        return HomeStore(flux)
    }
}