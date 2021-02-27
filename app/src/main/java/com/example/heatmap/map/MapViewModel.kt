package com.example.heatmap.map

import android.app.Application
import androidx.lifecycle.*
import androidx.preference.PreferenceManager
import com.example.heatmap.database.Planta
import com.example.heatmap.database.PlantaDao
import kotlinx.coroutines.launch


class MapViewModel(val database: PlantaDao, application: Application): AndroidViewModel(application) {
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

    private var _enables=MutableLiveData<Boolean>(true)
    val enables:LiveData<Boolean>
        get() = _enables

    private lateinit var plantaChile:Planta
    private lateinit var plantaUSA:Planta
    private lateinit var plantaColombia:Planta


    val datos=database.getPlanta()


    val preferences = PreferenceManager.getDefaultSharedPreferences(application)
    val editor=preferences.edit()


    init {
        val valor=preferences.getBoolean("save",false)
        _enables.value = !valor

    }




    fun setPlantas(){
        plantaChile=Planta(name="Planta Chile",
            facturacion = getOneOne.value,
            costos = getTwoOne.value,
            energia = getThreeOne.value,
            operarios = getFourOne.value)

        plantaUSA=Planta(name="Planta USA",
            facturacion = getOneTwo.value,
            costos = getTwoTwo.value,
            energia = getThreeTwo.value,
            operarios = getFourTwo.value)

        plantaColombia=Planta(name="Planta Colombia",
            facturacion = getOneThree.value,
            costos = getTwoThree.value,
            energia = getThreeThree.value,
            operarios = getFourThree.value)

    }


    fun save(){
        editor.putBoolean("save",true)
        editor.apply()
        setPlantas()
        _enables.value=false
        viewModelScope.launch{
            database.insert(plantaChile)
            database.insert(plantaUSA)
            database.insert(plantaColombia)
        }

    }

    fun enableText(){
        _enables.value=true
    }

    fun update(){
        _enables.value=false
        viewModelScope.launch {
            val updateChile=database.findDirectorByName("Planta Chile")
            updateChile?.facturacion=getOneOne.value
            updateChile?.costos=getTwoOne.value
            updateChile?.energia=getThreeOne.value
            updateChile?.operarios=getFourOne.value

            val updateUSA=database.findDirectorByName("Planta USA")
            updateUSA?.facturacion=getOneTwo.value
            updateUSA?.costos=getTwoTwo.value
            updateUSA?.energia=getThreeTwo.value
            updateUSA?.operarios=getFourTwo.value

            val updateColombia=database.findDirectorByName("Planta Colombia")
            updateColombia?.facturacion=getOneThree.value
            updateColombia?.costos=getTwoThree.value
            updateColombia?.energia=getThreeThree.value
            updateColombia?.operarios=getFourThree.value

            if (updateChile != null) {
                database.update(updateChile)
            }
            if (updateUSA != null) {
                database.update(updateUSA)
            }
            if (updateColombia != null) {
                database.update(updateColombia)
            }
        }
    }



    fun show(it: List<Planta?>) {
        if(it.size>0){
            _oneOne.value= (it[0]?.facturacion?:0F).toInt().toString()
            _twoOne.value= (it[0]?.costos?:0F).toInt().toString()
            _threeOne.value= (it[0]?.energia?:0F).toInt().toString()
            _fourOne.value= (it[0]?.operarios?:0F).toInt().toString()

            _oneTwo.value= (it[1]?.facturacion?:0F).toInt().toString()
            _twoTwo.value= (it[1]?.costos?:0F).toInt().toString()
            _threeTwo.value= (it[1]?.energia?:0F).toInt().toString()
            _fourTwo.value= (it[1]?.operarios?:0F).toInt().toString()

            _oneThree.value= (it[2]?.facturacion?:0F).toInt().toString()
            _twoThree.value= (it[2]?.costos?:0F).toInt().toString()
            _threeThree.value= (it[2]?.energia?:0F).toInt().toString()
            _fourThree.value= (it[2]?.operarios?:0F).toInt().toString()


        }

    }


}