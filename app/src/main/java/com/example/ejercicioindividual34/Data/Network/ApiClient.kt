package com.example.ejercicioindividual34.Data.Network

import com.example.ejercicioindividual34.Data.Model.MarsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("realestate")
    suspend fun getAllMars(): Response<List<MarsModel>>
}