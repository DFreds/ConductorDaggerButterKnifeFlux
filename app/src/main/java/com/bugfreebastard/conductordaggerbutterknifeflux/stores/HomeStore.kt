package com.bugfreebastard.conductordaggerbutterknifeflux.stores

import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.BUTTON_TAPPED
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.BUTTON_TEXT_KEY
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeReactions.Companion.UPDATE_BUTTON_TEXT
import com.nigelbrown.fluxion.Annotation.Action
import com.nigelbrown.fluxion.Annotation.Store
import com.nigelbrown.fluxion.Flux
import com.nigelbrown.fluxion.FluxAction
import com.nigelbrown.fluxion.FluxStore
import javax.inject.Inject

@Store
class HomeStore @Inject constructor(flux: Flux) : FluxStore(flux) {

    var buttonTappedCount = 0

    init {
        registerActionSubscriber(this)
    }

    @Action(actionType = BUTTON_TAPPED)
    fun buttonTapped(action: FluxAction) {
        buttonTappedCount++

        emitReaction(UPDATE_BUTTON_TEXT, BUTTON_TEXT_KEY, "Button tapped $buttonTappedCount times")
    }
}