package com.emreakcadag.architecturecomponents.base.model

/**
 * Created by Emre Akçadağ on 9.06.2020
 */
data class DialogBox(
    var title: String? = null,
    var description: String? = null,
    val isCancelable: Boolean? = null,
    var buttonList: List<ButtonModel>? = null
)