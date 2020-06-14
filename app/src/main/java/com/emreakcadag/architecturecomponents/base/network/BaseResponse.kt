package com.emreakcadag.architecturecomponents.base.network

import androidx.room.Embedded
import com.emreakcadag.architecturecomponents.base.model.DialogBox
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
open class BaseResponse {
    @SerializedName("url")
    var url: String? = null

    @SerializedName("dialogBox")
    @Embedded(prefix = "DialogBox")
    var dialogBox: DialogBox? = null
}