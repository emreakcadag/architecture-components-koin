package com.emreakcadag.architecturecomponents.base.extension

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.emreakcadag.architecturecomponents.BuildConfig
import com.emreakcadag.architecturecomponents.base.AppSession
import com.emreakcadag.architecturecomponents.base.model.KeyValueModel

/**
 * Created by Emre Akçadağ on 5.06.2020
 */

/**
 * Get tag for all class
 */
inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

inline fun <T> LifecycleOwner?.observeLiveData(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) = this?.run {
    Observer<T> { callback(it) }.also { liveData?.observe(this, it) }
}

inline fun <T> LiveData<T>?.observeLiveDataForever(crossinline callback: (T) -> Unit) = this?.run {
    Observer<T> { callback(it) }.also { observeForever(it) }
}

inline fun <T> LifecycleOwner?.observeLiveDataOnce(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) = takeUnless {
    liveData?.hasObservers() ?: false
}?.observeLiveData(liveData, callback)


fun <Key, Value> List<KeyValueModel.ViewEntity<Key, Value>>?.findValueByKey(key: Key?) =
    this?.find { it.key == key }?.value

fun Any?.toJson() = AppSession.instance.moshi?.run {
    this.adapter(Any::class.java).toJson(this@toJson)
}

inline fun <reified T> T.logDebug(message: String?) {
    if (BuildConfig.DEBUG) {
        Log.d("LogDebug: ${this.TAG}", "$message")
    }
}