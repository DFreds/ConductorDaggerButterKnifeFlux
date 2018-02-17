package com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators

interface HomeActions {
    fun buttonTapped()

    companion object {
        const val BUTTON_TAPPED = "button-tapped"
    }
}