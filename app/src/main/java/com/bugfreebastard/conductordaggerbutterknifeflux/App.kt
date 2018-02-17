package com.bugfreebastard.conductordaggerbutterknifeflux

import android.app.Application
import com.bugfreebastard.conductordaggerbutterknifeflux.di.*
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

class App : Application() {

    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        refWatcher = if (LeakCanary.isInAnalyzerProcess(this)) {
            RefWatcher.DISABLED
        } else {
            LeakCanary.install(this)
        }

        mInstance = this
        component = DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).actionsCreatorModule(ActionsCreatorModule()).storeModule(StoreModule()).build()
    }

    fun getComponent(): AppComponent? {
        return component
    }

    companion object {
        var refWatcher: RefWatcher? = null

        private var mInstance: App? = null

        @Synchronized
        fun getInstance(): App? {
            return mInstance
        }
    }

}