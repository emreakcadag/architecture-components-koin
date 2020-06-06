package com.emreakcadag.architecturecomponents.feature.main.data.repository

import com.emreakcadag.architecturecomponents.feature.main.data.MainApiService
import com.emreakcadag.architecturecomponents.network.BaseRemoteDataSource
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
class MainRemoteDataSource : BaseRemoteDataSource() {

    private val mainApiService: MainApiService by inject()

    suspend fun getNasaResponse() = safeApiCall(
        call = { mainApiService.getNasaResponse() },
        errorMessage = "Error Fetching Popular Movies"
    )?.toViewEntity()
}