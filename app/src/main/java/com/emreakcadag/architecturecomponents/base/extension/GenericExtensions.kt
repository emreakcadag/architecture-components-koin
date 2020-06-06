package com.emreakcadag.architecturecomponents.base.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.*

/**
 * Created by Emre Akçadağ on 5.06.2020
 */

/**
 * Get tag for all class
 */
inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

/**
 * <T> Any.negation(firstOperand: T, secondOperand: T)
 */
fun <T> Any.negation(firstOperand: T, secondOperand: T) = when {
    this == firstOperand -> secondOperand
    this == secondOperand -> firstOperand
    else -> throw IllegalStateException("IllegalStateException")
}

/**
 * LiveData bu extension ile observe edilebilir.
 */
inline fun <T> LifecycleOwner?.observeLiveData(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) =
    this?.run {
        Observer<T> { callback(it) }.also { liveData?.observe(this, it) }
    }

/**
 * LiveData bu extension ile observe edilebilir.
 */
inline fun <T> LiveData<T>?.observeLiveDataForever(crossinline callback: (T) -> Unit) =
    this?.run {
        Observer<T> { callback(it) }.also { observeForever(it) }
    }

/**
 * LiveData bu extension ile observe edilebilir.
 */
inline fun <T> LifecycleOwner?.observeLiveDataOnce(liveData: LiveData<T>?, crossinline callback: (T) -> Unit) =
    takeUnless {
        liveData?.hasObservers() ?: false
    }?.observeLiveData(liveData, callback)

/*
/**
 */
 * Find value by key

fun <Key, Value> List<KeyValueModel.ViewEntity<Key, Value>>?.findValueByKey(key: Key?) =
    this?.find { it.key == key }?.value*/