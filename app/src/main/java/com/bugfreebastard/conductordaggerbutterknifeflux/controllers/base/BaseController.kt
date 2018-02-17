package com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View


abstract class BaseController : RefWatchingController {

    // Note: This is just a quick demo of how an ActionBar *can* be accessed, not necessarily how it *should*
    // be accessed. In a production app, this would use Dagger instead.
    private val actionBar: ActionBar? = null
//        get() {
//            val actionBarProvider = activity as ActionBarProvider?
//            return if (actionBarProvider != null) actionBarProvider!!.getSupportActionBar() else null
//        }

    protected val title: String?
        get() = null

    protected constructor() {}

    protected constructor(args: Bundle) : super(args) {}

    override fun onAttach(view: View) {
        setTitle()
        super.onAttach(view)
    }

    protected fun setTitle() {
        var parentController = parentController
        while (parentController != null) {
            if (parentController is BaseController && parentController.title != null) {
                return
            }
            parentController = parentController.parentController
        }

        val title = title
        val actionBar = actionBar
        if (title != null && actionBar != null) {
            actionBar.setTitle(title)
        }
    }
}