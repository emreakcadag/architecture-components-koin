package com.emreakcadag.architecturecomponents.feature.main.data

import com.emreakcadag.architecturecomponents.feature.main.data.request.MainRequest
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
interface MainApiService {

    @POST
    suspend fun getNasaResponse(@Url endPoint: String?, @Body mainRequest: MainRequest?): Response<MainResponse?>
}