package com.emreakcadag.architecturecomponents.network

import com.emreakcadag.architecturecomponents.base.extension.logDebug
import com.emreakcadag.architecturecomponents.base.extension.toJson
import com.emreakcadag.architecturecomponents.network.room.AppDatabase
import org.koin.core.KoinComponent
import org.koin.core.get
import java.io.IOException

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
open class BaseLocalDataSource : KoinComponent {

    open val database = AppDatabase.getDatabase(get())

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
        val response = call.invoke()
        if (response != null) return BaseResult.Success(response)

        return BaseResult.Error(IOException("Error Occurred during getting safe LOCAL Api result, Custom ERROR - $errorMessage"))
    }
}