package com.emreakcadag.architecturecomponents.base.network

import com.emreakcadag.architecturecomponents.base.extension.logDebug
import com.emreakcadag.architecturecomponents.base.extension.toJson
import com.emreakcadag.architecturecomponents.base.network.room.AppDatabase
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.io.IOException

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
open class BaseLocalDataSource : KoinComponent {

    open val appDatabase: AppDatabase by inject()

    suspend fun <T : Any?> safeLocalApiCall(call: suspend () -> T?, errorMessage: String): T? {

        val result = safeLocalApiResult(call, errorMessage)
        var data: T? = null

        when (result) {
            is BaseResult.Success -> data = result.data
            is BaseResult.Error -> logDebug("$errorMessage & Exception - ${result.exception}")
        }

        logDebug(data.toJson())

        return data
    }

    private suspend fun <T : Any?> safeLocalApiResult(call: suspend () -> T?, errorMessage: String): BaseResult<T?> {
        var response: T? = null
        try {
            response = call.invoke()
        } catch (e: Exception) {
        }

        if (response != null) return BaseResult.Success(response)

        return BaseResult.Error(IOException("Error Occurred during getting safe LOCAL Api result, Custom ERROR - $errorMessage"))
    }
}