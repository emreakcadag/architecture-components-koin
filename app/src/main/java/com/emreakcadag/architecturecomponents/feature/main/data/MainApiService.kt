package com.emreakcadag.architecturecomponents.feature.main.data

import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
interface MainApiService {

    @GET
    suspend fun getNasaResponse(@Url endPoint: String?): Response<MainResponse?>
}