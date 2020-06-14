package com.emreakcadag.architecturecomponents.di

import com.emreakcadag.architecturecomponents.base.network.room.AppDatabase
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Emre Akçadağ on 5.06.2020
 *
 */
val networkModule = module {

    // https://api.nasa.gov/planetary/apod?api_key=SzVivPLHN7PCYZKtD3PupYZWeKPGTVS0Tx9F2VNh
    // http://192.168.1.102:3000/
    single(named("BASE_URL")) { "http://192.168.1.102:3000/" }

    single {
        val interceptor = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    single {
        val client = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        client.build()
    }

    single {
        AppDatabase.getDatabase(get())
    }

    single {
        Gson()
            .newBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create()
    }

    single {
        Retrofit.Builder().baseUrl(get<String>(named("BASE_URL")))
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
}
