package com.emreakcadag.architecturecomponents.feature.main.data.repository

import com.emreakcadag.architecturecomponents.base.network.BaseRepository
import com.emreakcadag.architecturecomponents.feature.main.data.repository.local.MainLocalDataSource
import com.emreakcadag.architecturecomponents.feature.main.data.repository.remote.MainRemoteDataSource
import com.emreakcadag.architecturecomponents.feature.main.data.request.MainRequest
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
class MainRepository : BaseRepository() {

    private val mainRemoteDataSource: MainRemoteDataSource by inject()

    private val mainLocalDataSource: MainLocalDataSource by inject()

    suspend fun getNasaResponse(mainRequest: MainRequest?) = mainRequest?.run {
        mainRemoteDataSource.getNasaResponse(this)?.also {

            // cache response to local room database
            mainLocalDataSource.cacheNasaResponse(it)
        }
    }

    /*
     * getLocalNasaResponse
     */
    suspend fun getLocalNasaResponse() = mainLocalDataSource.getLocalNasaResponse()
}