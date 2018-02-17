package com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators

import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.BUTTON_TAPPED
import com.nigelbrown.fluxion.Flux
import com.nigelbrown.fluxion.FluxActionCreator
import javax.inject.Inject

class HomeActionsCreator @Inject constructor(flux: Flux) : FluxActionCreator(flux), HomeActions {
    override fun buttonTapped() {
        emitAction(BUTTON_TAPPED)
    }
}