package com.example.ejercicioindividual34.Data

import androidx.lifecycle.map
import com.example.ejercicioindividual34.Data.Database.Dao.Dao
import com.example.ejercicioindividual34.Data.Database.Entities.MarsEntity
import com.example.ejercicioindividual34.Data.Model.MarsModel
import com.example.ejercicioindividual34.Data.Model.MarsProvider
import com.example.ejercicioindividual34.Data.Network.MarsService
import com.example.ejercicioindividual34.Domain.Model.Mars
import com.example.ejercicioindividual34.Domain.Model.toDomain
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: MarsService,
    private val marsDao: Dao) {

    suspend fun getAllMarsFromApi():List<Mars>{
        val response: List<MarsModel> = api.getMars()
        return response.map { it.toDomain() }
    }

    suspend fun getAllMarsFromDatabase():List<Mars>{
        val response: List<MarsEntity> = marsDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun insertMars(mars: List<MarsEntity>){
        marsDao.insertAll(mars)
    }

    suspend fun clearMars(){
        marsDao.deleteAllMars()
    }

    suspend fun getMarsById(itemId: String): List<Mars>{
        return marsDao.getMarsById(itemId)
    }


}