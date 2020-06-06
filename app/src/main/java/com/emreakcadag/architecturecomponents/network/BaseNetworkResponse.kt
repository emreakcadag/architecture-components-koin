package com.emreakcadag.architecturecomponents.network

import com.squareup.moshi.Json

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
open class BaseNetworkResponse {
    @Json(name = "url") var url: String? = null
}