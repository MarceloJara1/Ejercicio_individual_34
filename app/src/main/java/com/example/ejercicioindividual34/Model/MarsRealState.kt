package com.example.ejercicioindividual34.Model

import com.google.gson.annotations.SerializedName

data class MarsRealState(
    @SerializedName("id")
    val id: String,
    @SerializedName("price")
    val price : Long,
    @SerializedName("type")
    val type : String,
    @SerializedName("img_src")
    val img: String
    )

