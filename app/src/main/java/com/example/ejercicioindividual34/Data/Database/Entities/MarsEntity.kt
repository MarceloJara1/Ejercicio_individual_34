package com.example.ejercicioindividual34.Data.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ejercicioindividual34.Domain.Model.Mars

@Entity(tableName = "mars_table")
data class MarsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "price") val price: Long,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "img") val img: String
)

fun Mars.toDatabase() = MarsEntity(id, price, type, img)