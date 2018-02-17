package com.bugfreebastard.conductordaggerbutterknifeflux.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import com.bugfreebastard.conductordaggerbutterknifeflux.App
import com.bugfreebastard.conductordaggerbutterknifeflux.R
import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActionsCreator
import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base.BaseController
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.TOAST_TEXT
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeReactions.Companion.SHOW_TOAST
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeStore
import com.nigelbrown.fluxion.Annotation.React
import com.nigelbrown.fluxion.Reaction
import com.orhanobut.logger.Logger
import javax.inject.Inject

class HomeController : BaseController() {

    @Inject
    lateinit var homeActionsCreator: HomeActionsCreator

    @Inject
    lateinit var homeStore: HomeStore

    init {
        App.getInstance()?.getComponent()?.inject(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
            inflater.inflate(R.layout.controller_home, container, false)

    @OnClick(R.id.home_button)
    fun onHomeButtonClicked() {
        homeActionsCreator.buttonTapped()
    }

    @React(reactionType = SHOW_TOAST)
    fun showToast(reaction: Reaction) {
        Logger.d("Wow, I should show a toast with ${reaction.get<String>(TOAST_TEXT)}")
    }
}