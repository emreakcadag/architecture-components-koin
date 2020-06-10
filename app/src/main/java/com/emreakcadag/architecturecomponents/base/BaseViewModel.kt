package com.emreakcadag.architecturecomponents.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
open class BaseViewModel : ViewModel(), KoinComponent {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext = parentJob + Dispatchers.Default

    protected val scope = CoroutineScope(coroutineContext)

    fun cancelAllRequests() = coroutineContext.cancel()
}