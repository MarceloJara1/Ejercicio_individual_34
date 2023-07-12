package com.example.ejercicioindividual34.Data.Network

import com.example.ejercicioindividual34.Core.RetrofitHelper
import com.example.ejercicioindividual34.Data.Model.MarsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class MarsService @Inject constructor(private val api:ApiClient) {

    suspend fun getMars(): List<MarsModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllMars()
            response.body()?: emptyList()
        }

    }
}