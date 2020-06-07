package com.emreakcadag.architecturecomponents.network

import com.emreakcadag.architecturecomponents.di.networkModule
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */
class NetworkTest : KoinTest {

    private val baseUrl: String by lazy { get(named("BASE_URL")) as String }
    private val moshi: Moshi by inject()
    private val retrofit: Retrofit by inject()
    private val okHttpClient: OkHttpClient by inject()

    @Before
    fun setup() {
        startKoin {
            modules(listOf(networkModule))
        }
    }

    @After
    fun koinStop() {
        stopKoin()
    }

    @Test
    fun `Test BaseUrl Created`() {
        assert(baseUrl == "https://api.nasa.gov/planetary/")
    }

    @Test
    fun `Test Retrofit Created`() {
        assertNotNull(retrofit)
    }

    @Test
    fun `Test Moshi Created`() {
        assertNotNull(moshi)
    }

    @Test
    fun `Test OkHttpClient Created`() {
        assertNotNull(okHttpClient)
        assertTrue(okHttpClient.connectTimeoutMillis == 30000)
        assertTrue(okHttpClient.readTimeoutMillis == 30000)
        assertTrue(okHttpClient.writeTimeoutMillis == 30000)
        assertTrue(okHttpClient.interceptors.isEmpty())
    }
}