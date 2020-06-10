package com.emreakcadag.architecturecomponents.base.network

import com.emreakcadag.architecturecomponents.base.model.DialogBox
import com.squareup.moshi.Json

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
open class BaseResponse {
    @Json(name = "url")
    var url: String? = null

    @Json(name = "dialogBox")
    @Transient
    var dialogBox: DialogBox? = null
}