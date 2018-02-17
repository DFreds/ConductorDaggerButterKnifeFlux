package com.bugfreebastard.conductordaggerbutterknifeflux

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.HomeController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var router: Router? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        setSupportActionBar(main_toolbar)

        router = Conductor.attachRouter(
                this,
                main_controller_container,
                savedInstanceState
        )

        if (router?.hasRootController() == false) {
            router?.setRoot(RouterTransaction.with(HomeController()))
        }
    }

    override fun onBackPressed() {
        if (router?.handleBack() == false) {
            super.onBackPressed()
        }
    }

}
