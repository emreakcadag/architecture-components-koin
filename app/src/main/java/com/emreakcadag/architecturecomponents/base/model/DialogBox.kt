package com.emreakcadag.architecturecomponents.base.model

/**
 * Created by Emre Akçadağ on 9.06.2020
 */
data class DialogBox(
    var title: String? = null,
    var description: String? = null,
    var buttonList: List<String>? = null // TODO emreakcadag ButtonModel oluştur, Action, type, theme etc.
)