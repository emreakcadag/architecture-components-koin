package com.emreakcadag.architecturecomponents.base

import com.squareup.moshi.Moshi
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
class AppSession : KoinComponent {

    val moshi: Moshi by inject()

    companion object {

        @Volatile
        private lateinit var INSTANCE: AppSession

        val instance: AppSession
            get() = if (::INSTANCE.isInitialized) INSTANCE else {
                INSTANCE = AppSession()
                INSTANCE
            }
    }
}