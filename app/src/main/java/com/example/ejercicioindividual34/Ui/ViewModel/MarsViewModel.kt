package com.example.ejercicioindividual34.Ui.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicioindividual34.Data.Model.MarsModel
import com.example.ejercicioindividual34.Data.Repository
import com.example.ejercicioindividual34.Domain.GetMarsUseCase
import com.example.ejercicioindividual34.Domain.Model.Mars
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsViewModel @Inject constructor(
    private val getMarsUseCase:GetMarsUseCase
) : ViewModel() {

    val marsList = MutableLiveData<List<Mars>?>()
    private val _errorMessage = MutableLiveData<String>()

    fun onCreate(){
        viewModelScope.launch {

            try{
                val result: List<Mars> = getMarsUseCase()
                marsList.value = result
            }catch (e: Exception){
                _errorMessage.value = "Error al obtener los datos"
                Log.e(TAG, "Error al obtener los datos", e)
            }

            /*
            if (!result.isNullOrEmpty()) {
                marsList.value = result
            }*/

        }
    }
    companion object {
        private const val TAG = "MarsViewModel"
    }
}