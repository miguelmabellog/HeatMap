package com.example.heatmap.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "planta")
data class Planta (
    @PrimaryKey(autoGenerate = true)
    var newPoindId:Long=0L,

    var name: String="",

    var facturacion:Float?=0F,

    var costos:Float?=0F,

    var energia:Float?=0F,

    var operarios:Float?=0F
)