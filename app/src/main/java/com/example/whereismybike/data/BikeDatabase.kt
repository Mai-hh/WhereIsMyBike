package com.example.whereismybike.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whereismybike.model.Bike

@Database(entities = [Bike::class], version = 2, exportSchema = false)
abstract class BikeDatabase : RoomDatabase() {

    abstract val bikeDao: BikeDao

    companion object {
        @Volatile
        private var INSTANCE: BikeDatabase? = null

        fun getDatabase(context: Context): BikeDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BikeDatabase::class.java,
                    "bike_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                return instance

            }

        }

    }
}
