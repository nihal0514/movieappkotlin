package com.example.kotlinmovieapptry.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    fun getRetrofitClient(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl("https://moviesapi.ir/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}