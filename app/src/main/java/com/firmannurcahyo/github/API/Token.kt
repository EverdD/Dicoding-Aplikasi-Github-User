package com.firmannurcahyo.github.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Token {
    private const val BASE_URL = "https://api.github.com/"

    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy
    fun getTokenService(): TokenService {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TokenService::class.java)
    }
}
