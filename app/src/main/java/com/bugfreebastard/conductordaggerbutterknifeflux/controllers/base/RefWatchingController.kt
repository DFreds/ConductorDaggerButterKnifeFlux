package com.bugfreebastard.conductordaggerbutterknifeflux.controllers.base

import android.os.Bundle
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bugfreebastard.conductordaggerbutterknifeflux.App


abstract class RefWatchingController : ButterKnifeController {

    private var hasExited: Boolean = false

    protected constructor() {}
    protected constructor(args: Bundle) : super(args) {}

    public override fun onDestroy() {
        super.onDestroy()

        if (hasExited) {
            App.refWatcher?.watch(this)
        }
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        hasExited = !changeType.isEnter
        if (isDestroyed) {
            App.refWatcher?.watch(this)
        }
    }
}