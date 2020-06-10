package com.emreakcadag.architecturecomponents.base.applicationlistener

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.emreakcadag.architecturecomponents.base.extension.logDebug
import java.util.*

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 * Since many have to implement this, then create a default class
 */
private interface CurrentActivityListener {
    val currentActivity: Activity?
}

class DefaultCurrentActivityListener : Application.ActivityLifecycleCallbacks, CurrentActivityListener {

    override var currentActivity: Activity? = null
    lateinit var context: Context
    private var currentActivityStack: MutableList<Activity> = ArrayList()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        currentActivity = activity
        context = activity
        currentActivityStack.add(activity)

        logDebug("${activity::class.simpleName} onActivityCreated")
    }

    /*
     * Check if the activity of the given class is running
     * @param activityClass
     * @return true if running
     */
    fun isActivityRunning(activityClass: Class<out Activity>): Boolean {
        for (activity in currentActivityStack) {
            if (activity.javaClass == activityClass) {
                return true
            }
        }
        return false
    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        if (activity == currentActivity) {
            currentActivity = null
        }
        logDebug("${activity::class.simpleName} onActivityDestroyed")
        currentActivityStack.remove(activity)
    }
}