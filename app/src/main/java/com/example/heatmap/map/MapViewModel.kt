package com.example.heatmap.map

import android.app.Application
import androidx.lifecycle.*


class MapViewModel(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    var _oneOne = MutableLiveData<String>()

    val getOneOne=Transformations.map(_oneOne){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _oneTwo = MutableLiveData<String>()

    val getOneTwo=Transformations.map(_oneTwo){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _oneThree = MutableLiveData<String>()

    val getOneThree=Transformations.map(_oneThree){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }






}