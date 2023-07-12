package com.example.ejercicioindividual34.Domain

import com.example.ejercicioindividual34.Data.Database.Entities.toDatabase
import com.example.ejercicioindividual34.Data.Repository
import com.example.ejercicioindividual34.Domain.Model.Mars
import javax.inject.Inject

class GetMarsUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke():List<Mars>{
        val mars = repository.getAllMarsFromApi()

        return if (mars.isNotEmpty()){
            repository.clearMars()
            repository.insertMars(mars.map { it.toDatabase() })
            mars
        }else{
            repository.getAllMarsFromDatabase()
        }
    }
}