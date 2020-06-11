package com.emreakcadag.architecturecomponents.base.network

import com.emreakcadag.architecturecomponents.base.DialogBoxHandler
import com.emreakcadag.architecturecomponents.base.extension.dialogBoxChecker
import com.emreakcadag.architecturecomponents.base.extension.logDebug
import com.emreakcadag.architecturecomponents.base.extension.toJson
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response
import java.io.IOException

/**
 * Created by Emre Akçadağ on 6.06.2020
 */
open class BaseRemoteDataSource : KoinComponent {

    private val dialogBoxHandler: DialogBoxHandler by inject()

    suspend fun <T : Any?> safeApiCall(call: suspend () -> Response<T?>, errorMessage: String): T? {

        val result: BaseResult<T?> = safeApiResult(call, errorMessage)
        var data: T? = null

        when (result) {
            is BaseResult.Success -> data = result.data
            is BaseResult.Error -> logDebug("$errorMessage & Exception - ${result.exception}")
        }

        logDebug(data.toJson())

        // Gelen response'e bakar [DialogBox] varsa DialogBoxHandler ile DialogBox gösterilir.
        if (dialogBoxChecker(data)) {
            dialogBoxHandler.showDialogBox((data as? BaseResponse?)?.dialogBox)
        }

        return data
    }

    private suspend fun <T : Any?> safeApiResult(call: suspend () -> Response<T?>, errorMessage: String): BaseResult<T?> {
        val response = call.invoke()
        if (response.isSuccessful) return BaseResult.Success(response.body())

        return BaseResult.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}