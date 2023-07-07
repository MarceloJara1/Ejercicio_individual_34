package com.example.ejercicioindividual34.Model

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    // vieja confiable
    @GET("realestate")
    fun fetchMarsData(): Call<List<MarsRealState>>


    // parte 2 coroutines
    @GET("realestate")
    suspend fun fetchMarsDataCoroutines(): Response<List<MarsRealState>>
}