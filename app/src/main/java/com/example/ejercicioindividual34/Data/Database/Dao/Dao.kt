package com.example.ejercicioindividual34.Data.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejercicioindividual34.Data.Database.Entities.MarsEntity
import com.example.ejercicioindividual34.Domain.Model.Mars

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(marsRealState: List<MarsEntity>)

    @Query("SELECT * FROM mars_table")
    fun getAll(): List<MarsEntity>

    @Query("DELETE FROM mars_table")
    suspend fun deleteAllMars()

    @Query("SELECT * FROM mars_table WHERE id = :marsId")
    fun getMarsById(marsId: String): List<Mars>
}