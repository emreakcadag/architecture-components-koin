package com.emreakcadag.architecturecomponents.base.applicationlistener

import android.content.Context
import android.view.LayoutInflater

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
class ActivityRetriever(private val defaultCurrentActivityListener: DefaultCurrentActivityListener) {

    val layoutInflater = LayoutInflater.from(defaultCurrentActivityListener.currentActivity)

    val context: Context = defaultCurrentActivityListener.context

    fun getActivity() = defaultCurrentActivityListener.currentActivity
}