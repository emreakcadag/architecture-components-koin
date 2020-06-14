package com.emreakcadag.architecturecomponents.feature.main.data.repository.local

import com.emreakcadag.architecturecomponents.base.network.BaseLocalDataSource
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
class MainLocalDataSource : BaseLocalDataSource() {

    suspend fun getLocalNasaResponse() = safeLocalApiCall(
        call = { appDatabase.mainResponseDao().getOne() },
        errorMessage = "Error Fetching Main LOCAL Response"
    )

    /*
     * cache response with room
     */
    fun cacheNasaResponse(nasaResponse: MainResponse?) = appDatabase.mainResponseDao().insertAll(nasaResponse)
}