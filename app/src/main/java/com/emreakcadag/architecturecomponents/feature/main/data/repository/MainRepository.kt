package com.emreakcadag.architecturecomponents.feature.main.data.repository

import com.emreakcadag.architecturecomponents.network.BaseRepository
import org.koin.core.inject

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
class MainRepository : BaseRepository() {

    private val mainRemoteDataSource: MainRemoteDataSource by inject()

    suspend fun getNasaResponse() = mainRemoteDataSource.getNasaResponse()
}