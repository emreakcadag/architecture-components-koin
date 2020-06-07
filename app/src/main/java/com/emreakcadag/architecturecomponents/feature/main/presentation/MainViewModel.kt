package com.emreakcadag.architecturecomponents.feature.main.presentation

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreakcadag.architecturecomponents.base.BaseViewModel
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

    private val response = MutableLiveData<MainResponse.ViewEntity>()
    val responseLiveData: LiveData<MainResponse.ViewEntity> get() = response

    val helloWorldObservable = ObservableField("Emre")

    fun sendRequest() {
        scope.launch {
            try {

                val request = MainRequest()
                val res = mainRepository.getNasaResponse(request)
                response.postValue(res)
                helloWorldObservable.set("HelloWorld")
            } catch (e: Exception) {
                Log.d("EMREE", e.toString())
            }
        }
    }
}