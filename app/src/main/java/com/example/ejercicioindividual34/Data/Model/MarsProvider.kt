package com.example.ejercicioindividual34.Data.Model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarsProvider @Inject constructor(){
        var mars:List<MarsModel> = emptyList()
}