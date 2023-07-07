package com.example.ejercicioindividual34.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {

        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"


        fun getRetrofit(): APIService {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            return retrofit.create(APIService::class.java)


        }


    }
}