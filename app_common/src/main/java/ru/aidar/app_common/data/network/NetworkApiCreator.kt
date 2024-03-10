package ru.aidar.app_common.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkApiCreator(
    private val okHttpClient: OkHttpClient,
    private val dogUrl: String,
    private val catUrl: String,
) {
    fun <T> catCreate(service: Class<T>) = create(service = service, url = catUrl)

    fun <T> dogCreate(service: Class<T>) = create(service = service, url = dogUrl)

    private fun <T> create(
        service: Class<T>,
        url: String,
    ): T {
        val retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(service)
    }
}
