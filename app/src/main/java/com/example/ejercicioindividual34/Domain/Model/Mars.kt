package com.example.ejercicioindividual34.Domain.Model

import com.example.ejercicioindividual34.Data.Database.Entities.MarsEntity
import com.example.ejercicioindividual34.Data.Model.MarsModel

data class Mars(
    val id: String,
    val price : Long,
    val type : String,
    val img: String)

fun MarsModel.toDomain() = Mars(id, price, type, img)
fun MarsEntity.toDomain() = Mars(id, price, type, img)