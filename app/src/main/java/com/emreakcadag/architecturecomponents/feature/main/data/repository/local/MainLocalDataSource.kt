package com.emreakcadag.architecturecomponents.feature.main.data.repository.local

import com.emreakcadag.architecturecomponents.feature.main.data.request.MainRequest
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import com.emreakcadag.architecturecomponents.base.network.BaseLocalDataSource

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
class MainLocalDataSource : BaseLocalDataSource() {

    suspend fun getLocalNasaResponse(mainRequest: MainRequest?) = safeLocalApiCall(
        call = { database.mainResponseDao().getOne() },
        errorMessage = "Error Fetching Main LOCAL Response"
    )

    /*
     * cache response with room
     */
    fun cacheNasaResponse(nasaResponse: MainResponse?) = database.mainResponseDao().insertAll(nasaResponse)
}
