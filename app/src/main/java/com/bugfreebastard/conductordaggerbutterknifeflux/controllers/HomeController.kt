package com.bugfreebastard.conductordaggerbutterknifeflux.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.BindView
import butterknife.OnClick
import com.bugfreebastard.conductordaggerbutterknifeflux.App
import com.bugfreebastard.conductordaggerbutterknifeflux.R
import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActionsCreator
import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base.BaseController
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.BUTTON_TEXT_KEY
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeReactions.Companion.UPDATE_BUTTON_TEXT
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeStore
import com.nigelbrown.fluxion.Annotation.React
import com.nigelbrown.fluxion.Flux
import com.nigelbrown.fluxion.Reaction
import javax.inject.Inject

class HomeController : BaseController() {

    @Inject
    lateinit var homeActionsCreator: HomeActionsCreator

    @Inject
    lateinit var homeStore: HomeStore

    @BindView(R.id.home_button)
    lateinit var homeButton: Button

    init {
        App.getInstance()?.getComponent()?.inject(this)
        Flux.getsInstance().registerReactionSubscriber(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
            inflater.inflate(R.layout.controller_home, container, false)

    override fun onViewBound(view: View) {
        super.onViewBound(view)
        homeButton.text = "Button tapped ${homeStore.buttonTappedCount} times"
    }

    @OnClick(R.id.home_button)
    fun onHomeButtonClicked() {
        homeActionsCreator.buttonTapped()
    }

    @React(reactionType = UPDATE_BUTTON_TEXT)
    fun updateButtonText(reaction: Reaction) {
        homeButton.text = reaction.get(BUTTON_TEXT_KEY)
    }
}