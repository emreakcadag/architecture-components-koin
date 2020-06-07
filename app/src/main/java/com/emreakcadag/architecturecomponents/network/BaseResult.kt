package com.emreakcadag.architecturecomponents.network

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
sealed class BaseResult<out T : Any?> {
    data class Success<out T : Any?>(val data: T?) : BaseResult<T?>()
    data class Error(val exception: Exception) : BaseResult<Nothing>()
}