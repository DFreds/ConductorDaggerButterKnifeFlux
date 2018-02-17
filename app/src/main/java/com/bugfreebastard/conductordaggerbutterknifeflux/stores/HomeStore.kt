package com.bugfreebastard.conductordaggerbutterknifeflux.stores

import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.COUNTER_BUTTON_TAPPED
import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActions.Companion.RESET_COUNT_BUTTON_TAPPED
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.COUNTER_BUTTON_TEXT_KEY
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
        private set

    init {
        registerActionSubscriber(this)
    }

    @Action(actionType = COUNTER_BUTTON_TAPPED)
    fun counterButtonTapped(action: FluxAction) {
        buttonTappedCount++

        emitReaction(UPDATE_BUTTON_TEXT, COUNTER_BUTTON_TEXT_KEY, "Button tapped $buttonTappedCount times")
    }

    @Action(actionType = RESET_COUNT_BUTTON_TAPPED)
    fun resetCountButtonTapped(action: FluxAction) {
        buttonTappedCount = 0

        emitReaction(UPDATE_BUTTON_TEXT, COUNTER_BUTTON_TEXT_KEY, "Button tapped $buttonTappedCount times")
    }
}