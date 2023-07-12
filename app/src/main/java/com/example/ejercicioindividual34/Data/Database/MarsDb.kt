package com.example.ejercicioindividual34.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejercicioindividual34.Data.Database.Dao.Dao
import com.example.ejercicioindividual34.Data.Database.Entities.MarsEntity

@Database(entities = [MarsEntity::class], version = 1)
abstract class MarsDb: RoomDatabase() {
    abstract fun getMarsDao():Dao
}