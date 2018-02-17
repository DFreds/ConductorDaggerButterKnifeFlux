package com.bugfreebastard.conductordaggerbutterknifeflux.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.BindView
import butterknife.OnClick
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bugfreebastard.conductordaggerbutterknifeflux.App
import com.bugfreebastard.conductordaggerbutterknifeflux.R
import com.bugfreebastard.conductordaggerbutterknifeflux.actionscreators.HomeActionsCreator
import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base.BaseController
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.COUNTER_BUTTON_TEXT_KEY
import com.bugfreebastard.conductordaggerbutterknifeflux.keys.HomeKeys.Companion.COUNTER_VALUE_KEY
import com.bugfreebastard.conductordaggerbutterknifeflux.stores.HomeReactions.Companion.GO_TO_DETAIL_VIEW
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

    @BindView(R.id.counter_button)
    lateinit var counterButton: Button

    @BindView(R.id.reset_count_button)
    lateinit var resetCountButton: Button

    @BindView(R.id.next_view_button)
    lateinit var nextViewButton: Button

    init {
        App.getInstance()?.getComponent()?.inject(this)
        Flux.getsInstance().registerReactionSubscriber(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
            inflater.inflate(R.layout.controller_home, container, false)

    override fun onViewBound(view: View) {
        super.onViewBound(view)
        counterButton.text = "Button tapped ${homeStore.buttonTappedCount} times"
    }

    @OnClick(R.id.counter_button)
    fun onCounterButtonTapped() {
        homeActionsCreator.counterButtonTapped()
    }

    @OnClick(R.id.reset_count_button)
    fun onResetCountButtonTapped() {
        homeActionsCreator.resetCountButtonTapped()
    }

    @OnClick(R.id.next_view_button)
    fun onNextViewButtonTapped() {
        homeActionsCreator.nextViewButtonTapped()
    }

    @React(reactionType = UPDATE_BUTTON_TEXT)
    fun updateButtonText(reaction: Reaction) {
        counterButton.text = reaction.get(COUNTER_BUTTON_TEXT_KEY)
    }

    @React(reactionType = GO_TO_DETAIL_VIEW)
    fun goToDetailView(reaction: Reaction) {
        val buttonTappedCount = reaction.get<Int>(COUNTER_VALUE_KEY)

        router.pushController(RouterTransaction
                .with(DetailController(buttonTappedCount))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
    }
}