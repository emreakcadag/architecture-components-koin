package com.emreakcadag.architecturecomponents.base.extension

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.emreakcadag.architecturecomponents.BuildConfig
import com.emreakcadag.architecturecomponents.base.AppSession
import com.emreakcadag.architecturecomponents.base.model.KeyValueModel
import com.emreakcadag.architecturecomponents.base.network.BaseResponse

/**
 * Created by Emre Akçadağ on 5.06.2020
 */

/**
 * Get tag for all class
 */
inline val <reified T> T.TAG: String get() = T::class.java.simpleName

/*
 * Observe LiveData
 */
inline fun <T> LifecycleOwner?.observeLiveData(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) = this?.run {
    Observer<T> { callback(it) }.also { liveData?.observe(this, it) }
}

/*
 * Observe LiveData forever
 */
inline fun <T> LiveData<T>?.observeLiveDataForever(crossinline callback: (T) -> Unit) = this?.run {
    Observer<T> { callback(it) }.also { observeForever(it) }
}

/*
 * Observe LiveData once
 */
inline fun <T> LifecycleOwner?.observeLiveDataOnce(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) = takeUnless {
    liveData?.hasObservers() ?: false
}?.observeLiveData(liveData, callback)

/*
 * KeyValueModel find value
 */
fun <Key, Value> List<KeyValueModel.ViewEntity<Key, Value>>?.findValueByKey(key: Key?) = this?.find { it.key == key }?.value

/*
 * Any object to json string
 */
fun Any?.toJson() = this?.run {
    AppSession.instance.gson.toJson(this@toJson)
}

/*
 * Json string to reified object
 */
inline fun <reified T : Any?> String?.fromJson() = this?.run {
    AppSession.instance.gson.fromJson(this@fromJson, T::class.java)
}

/*
 * Log received message, works only debug mode
 */
inline fun <reified T> T.logDebug(message: String?) {
    if (BuildConfig.DEBUG) {
        Log.d("LogDebug: ${this.TAG}", "$message")
    }
}

/*
* Checks and return true if data contains nonnull DialogBox field
*/
fun <T> dialogBoxChecker(data: T?): Boolean {
    data as BaseResponse
    return data.dialogBox != null
}