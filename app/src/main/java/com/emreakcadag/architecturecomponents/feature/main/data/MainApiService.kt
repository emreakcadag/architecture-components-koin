package com.emreakcadag.architecturecomponents.feature.main.data

import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
interface MainApiService {

    @GET("apod?api_key=SzVivPLHN7PCYZKtD3PupYZWeKPGTVS0Tx9F2VNh")
    suspend fun getNasaResponse(): Response<MainResponse?>
}