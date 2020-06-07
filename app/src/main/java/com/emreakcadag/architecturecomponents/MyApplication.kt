package com.emreakcadag.architecturecomponents

import android.app.Application
import com.emreakcadag.architecturecomponents.base.applicationlistener.DefaultCurrentActivityListener
import com.emreakcadag.architecturecomponents.di.appModule
import com.emreakcadag.architecturecomponents.di.networkModule
import com.emreakcadag.architecturecomponents.feature.main.mainModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
class MyApplication : Application() {

    private val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    appModule,
                    mainModule
                )
            )
        }

        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }
}