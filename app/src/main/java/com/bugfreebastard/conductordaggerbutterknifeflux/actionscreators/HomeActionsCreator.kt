package com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators

import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.COUNTER_BUTTON_TAPPED
import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.RESET_COUNT_BUTTON_TAPPED
import com.nigelbrown.fluxion.Flux
import com.nigelbrown.fluxion.FluxActionCreator
import javax.inject.Inject

class HomeActionsCreator @Inject constructor(flux: Flux) : FluxActionCreator(flux), HomeActions {
    override fun counterButtonTapped() {
        emitAction(COUNTER_BUTTON_TAPPED)
    }

    override fun resetCountButtonTapped() {
        emitAction(RESET_COUNT_BUTTON_TAPPED)
    }
}