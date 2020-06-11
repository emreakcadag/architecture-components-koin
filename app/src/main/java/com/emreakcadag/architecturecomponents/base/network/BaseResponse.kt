package com.emreakcadag.architecturecomponents.base.network

import androidx.room.Embedded
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
    @Embedded(prefix = "dialogBox")
    var dialogBox: DialogBox? = null
}