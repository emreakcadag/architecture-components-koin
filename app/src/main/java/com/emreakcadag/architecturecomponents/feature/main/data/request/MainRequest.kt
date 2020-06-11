package com.emreakcadag.architecturecomponents.feature.main.data.request

import com.emreakcadag.architecturecomponents.base.network.BaseNetworkRequest

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
data class MainRequest(
    val showDialog: Boolean? = null
) : BaseNetworkRequest("/main")