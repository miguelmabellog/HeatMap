package com.example.heatmap.map

import android.app.Application
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.example.heatmap.R


class MapViewModel(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    //variable that will listen to user's input
    var _userInput = MutableLiveData<String>()
    //expose the variable to the owner(activity/fragment)

    val getdata=Transformations.map(_userInput){
        if(it==""){
            0F
        }
        else{
            it.toFloat()
        }
    }






}