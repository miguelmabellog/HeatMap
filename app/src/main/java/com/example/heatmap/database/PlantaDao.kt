package com.example.heatmap.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlantaDao {

    @Insert
    suspend fun insert(planta: Planta)

    @Update
    suspend fun update(planta: Planta)

    @Delete
    suspend fun delete(pointDate: Planta)

    @Query("SELECT * FROM planta ")
    fun getPlanta(): LiveData<List<Planta?>>

    @Query("SELECT * FROM planta WHERE name = :fullName LIMIT 1")
    suspend fun findDirectorByName(fullName: String?): Planta?

    @Query("DELETE FROM planta")
    suspend fun deleteAll()
}