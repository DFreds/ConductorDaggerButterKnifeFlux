package com.bugfreebastard.conductordaggerbutterknifeflux.di

import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.HomeController
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (StoreModule::class), (ActionsCreatorModule::class)])
interface AppComponent {
    fun inject(homeController: HomeController)
}