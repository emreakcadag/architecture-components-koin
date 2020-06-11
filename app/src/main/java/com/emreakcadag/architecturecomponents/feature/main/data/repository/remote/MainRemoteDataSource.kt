package com.emreakcadag.architecturecomponents.feature.main.data.repository.remote

import com.emreakcadag.architecturecomponents.base.network.BaseRemoteDataSource
import com.emreakcadag.architecturecomponents.feature.main.data.MainApiService
import com.emreakcadag.architecturecomponents.feature.main.data.request.MainRequest
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
class MainRemoteDataSource : BaseRemoteDataSource() {

    private val mainApiService: MainApiService by inject()

    suspend fun getNasaResponse(mainRequest: MainRequest?) = safeApiCall(
        call = { mainApiService.getNasaResponse(mainRequest?.endPoint, mainRequest) },
        errorMessage = "Error Fetching Main Response"
    )
}