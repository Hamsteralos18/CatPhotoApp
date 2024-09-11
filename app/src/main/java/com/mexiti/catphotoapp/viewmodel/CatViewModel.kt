package com.mexiti.catphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.catphotoapp.network.CatApi
import kotlinx.coroutines.launch
import java.io.IOException


//Que herede de
class CatViewModel:ViewModel(){
    var catUiState by mutableStateOf("")
    private set

    //constructor, aqui es donde extraemos la cadena
    init {
        getCatPhotos()
    }






    //get es una corrutina, necesita metodo para llamar
    fun getCatPhotos(){
        viewModelScope.launch {
            try {
                val listResult = CatApi.retrofiService.getPhotos()
                catUiState = listResult
            }
            catch (e: IOException){}

        }
    }
}