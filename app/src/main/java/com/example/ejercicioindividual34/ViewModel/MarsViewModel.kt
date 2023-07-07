package com.example.ejercicioindividual34.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicioindividual34.Model.ApiClient
import com.example.ejercicioindividual34.Model.MarsRealState
import com.example.ejercicioindividual34.Model.Repository

import kotlinx.coroutines.launch

class MarsViewModel(application: Application) : AndroidViewModel(application) {

    // parte 1 comunicar con el repository

    private val repository : Repository

    // parte 2
    var  liveDatafromInternet :LiveData<List<MarsRealState>>

    init {

        repository= Repository()
        liveDatafromInternet = repository.fetchDataMars()

    }
}