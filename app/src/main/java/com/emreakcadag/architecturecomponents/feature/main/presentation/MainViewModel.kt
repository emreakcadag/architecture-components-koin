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

    private val request = MainRequest()

    private val response = MutableLiveData<MainResponse?>()
    val responseLiveData: LiveData<MainResponse?> get() = response

    val helloWorldObservable = ObservableField("Emre")

    fun getMainResponseData() {

        scope.launch {

            mainRepository.getLocalNasaResponse(request)?.also {
                response.postValue(it)
            }

            try {
                val remoteRes = mainRepository.getNasaResponse(request)
                if (response.value != remoteRes) {
                    response.postValue(remoteRes)
                }
                helloWorldObservable.set("HelloWorld")
            } catch (e: Exception) {
                this@MainViewModel.logDebug("$e")
            }
        }
    }
}