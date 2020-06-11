package com.emreakcadag.architecturecomponents.di

import com.emreakcadag.architecturecomponents.base.DialogBoxHandler
import com.emreakcadag.architecturecomponents.base.applicationlistener.ActivityRetriever
import com.emreakcadag.architecturecomponents.base.applicationlistener.DefaultCurrentActivityListener
import org.koin.dsl.module

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */

val appModule = module {

    single { DefaultCurrentActivityListener() }

    single {
        ActivityRetriever(
            get()
        )
    }

    single { DialogBoxHandler() }
}