package com.emreakcadag.architecturecomponents.network

import android.util.Log
import com.emreakcadag.architecturecomponents.BuildConfig
import com.emreakcadag.architecturecomponents.base.extension.TAG
import com.squareup.moshi.Moshi
import org.koin.core.KoinComponent
import org.koin.core.get
import retrofit2.Response
import java.io.IOException

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
open class BaseRemoteDataSource : KoinComponent {

    suspend fun <T : Any?> safeApiCall(call: suspend () -> Response<T?>, errorMessage: String): T? {

        val result: BaseResult<T?> = safeApiResult(call, errorMessage)
        var data: T? = null

        when (result) {
            is BaseResult.Success -> data = result.data
            is BaseResult.Error -> Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
        }

        if (BuildConfig.DEBUG) {
            Log.d(TAG, get<Moshi>().adapter(Any::class.java).toJson(data))
        }

        return data
    }

    private suspend fun <T : Any?> safeApiResult(call: suspend () -> Response<T?>, errorMessage: String): BaseResult<T?> {
        val response = call.invoke()
        if (response.isSuccessful) return BaseResult.Success(response.body())

        return BaseResult.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}