package com.emreakcadag.architecturecomponents.base.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
open class BaseRequest(val endPoint: String) {
    @SerializedName("language")
    var language: String? = null
}