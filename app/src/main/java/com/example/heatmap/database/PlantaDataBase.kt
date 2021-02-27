package com.example.heatmap.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Planta::class], version = 1, exportSchema = false)
abstract class PlantaDatabase : RoomDatabase() {
    abstract val plantaDao: PlantaDao

    companion object{
        @Volatile
        private var INSTANCE: PlantaDatabase? = null

        fun getInstance(context: Context): PlantaDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlantaDatabase::class.java,
                        "planta_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}