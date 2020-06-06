package com.emreakcadag.architecturecomponents.feature.main

import com.emreakcadag.architecturecomponents.feature.main.data.MainApiService
import com.emreakcadag.architecturecomponents.feature.main.data.repository.MainRemoteDataSource
import com.emreakcadag.architecturecomponents.feature.main.data.repository.MainRepository
import com.emreakcadag.architecturecomponents.feature.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 5.06.2020
 */

val mainModule = module {
    viewModel { MainViewModel() }

    single { MainRepository() }

    single { MainRemoteDataSource() }

    single {
        get<Retrofit>().create(MainApiService::class.java)
    }
}