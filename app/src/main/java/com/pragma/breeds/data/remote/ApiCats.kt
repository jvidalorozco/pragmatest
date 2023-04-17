package com.pragma.breeds.data.remote

import com.pragma.breeds.data.model.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiCats {
    @GET("breeds")
    suspend fun getBreeds(@Header("x-api-key") apiKey: String): Response<List<Cat>>
}