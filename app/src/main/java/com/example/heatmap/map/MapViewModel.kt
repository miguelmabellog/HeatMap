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


    var _twoOne = MutableLiveData<String>()

    val getTwoOne=Transformations.map(_twoOne){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _twoTwo = MutableLiveData<String>()

    val getTwoTwo=Transformations.map(_twoTwo){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _twoThree = MutableLiveData<String>()

    val getTwoThree=Transformations.map(_twoThree){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }


    var _threeOne = MutableLiveData<String>()

    val getThreeOne=Transformations.map(_threeOne){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _threeTwo = MutableLiveData<String>()

    val getThreeTwo=Transformations.map(_threeTwo){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _threeThree = MutableLiveData<String>()

    val getThreeThree=Transformations.map(_threeThree){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _fourOne = MutableLiveData<String>()

    val getFourOne=Transformations.map(_fourOne){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _fourTwo = MutableLiveData<String>()

    val getFourTwo=Transformations.map(_fourTwo){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }

    var _fourThree = MutableLiveData<String>()

    val getFourThree=Transformations.map(_fourThree){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }



}