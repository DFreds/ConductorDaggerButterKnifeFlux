package com.bugfreebastard.conductordaggerbutterknifeflux.di

import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActionsCreator
import com.nigelbrown.fluxion.Flux
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionsCreatorModule {
    @Singleton
    @Provides
    fun provideHomeActionsCreator(flux: Flux): HomeActionsCreator {
        return HomeActionsCreator(flux)
    }
}