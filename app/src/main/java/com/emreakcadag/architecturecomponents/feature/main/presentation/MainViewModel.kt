package com.emreakcadag.architecturecomponents.feature.main.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreakcadag.architecturecomponents.base.BaseViewModel
import com.emreakcadag.architecturecomponents.base.extension.logDebug
import com.emreakcadag.architecturecomponents.feature.main.data.repository.MainRepository
import com.emreakcadag.architecturecomponents.feature.main.data.request.MainRequest
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import kotlinx.coroutines.launch
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
class MainViewModel : BaseViewModel() {

    private val mainRepository: MainRepository by inject()

    private val request = MainRequest(showDialog = true)

    private val responseData = MutableLiveData<MainResponse?>()
    val responseLiveData: LiveData<MainResponse?> get() = responseData

    val helloWorldObservable = ObservableField("Emre")
    val mediaResourceObservable = ObservableField<Any?>()

    fun getMainResponseData() {

        scope.launch {

            try {
                mainRepository.getLocalNasaResponse()?.also {
                    handleData(it)
                }
            } catch (e: Exception) {
                this@MainViewModel.logDebug("$e")
            }

            try {
                mainRepository.getNasaResponse(request)?.also {
                    handleData(it)
                }
                helloWorldObservable.set("onRemoteResponse")
            } catch (e: Exception) {
                this@MainViewModel.logDebug("$e")
            }
        }
    }

    private fun handleData(response: MainResponse?) {
        if (responseData.value != response) {
            responseData.postValue(response)
            mediaResourceObservable.set(response?.url)
        }
    }
}