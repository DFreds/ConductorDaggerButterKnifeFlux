package com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators

interface HomeActions {
    fun counterButtonTapped()
    fun resetCountButtonTapped()
    fun nextViewButtonTapped()

    companion object {
        const val COUNTER_BUTTON_TAPPED = "counter-button-tapped"
        const val RESET_COUNT_BUTTON_TAPPED = "reset-count-button-tapped"
        const val NEXT_VIEW_BUTTON_TAPPED = "next-view-button-tapped"
    }
}