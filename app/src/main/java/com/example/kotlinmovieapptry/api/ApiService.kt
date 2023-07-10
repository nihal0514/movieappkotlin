package com.example.kotlinmovieapptry.api

import com.example.kotlinmovieapptry.model.ResponseMovieList
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("movies")
    fun getQuotes(): Call<ResponseMovieList>
}