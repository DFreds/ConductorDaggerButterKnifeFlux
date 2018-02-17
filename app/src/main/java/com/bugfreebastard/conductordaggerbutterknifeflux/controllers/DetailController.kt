package com.bugfreebastard.conductordaggerbutterknifeflux.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import com.bugfreebastard.conductordaggerbutterknifeflux.R
import com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base.BaseController

class DetailController(private val buttonTappedCount: Int? = null) : BaseController() {

    @BindView(R.id.detail_text_view)
    lateinit var detailTextView: TextView

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
            inflater.inflate(R.layout.controller_detail, container, false)

    override fun onViewBound(view: View) {
        super.onViewBound(view)
        detailTextView.text = "You tapped the button on the previous page $buttonTappedCount times"
    }
}