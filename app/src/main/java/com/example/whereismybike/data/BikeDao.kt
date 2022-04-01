package com.example.whereismybike.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.whereismybike.model.Bike
import kotlinx.coroutines.flow.Flow

@Dao
interface BikeDao {

    @Query("SELECT * FROM bike_db")
    fun getAllBikes(): Flow<List<Bike>>

    @Query("SELECT * FROM bike_db WHERE id = :id")
    fun getBikeById(id: Int): Flow<Bike>

    @Insert
    suspend fun insertBike(bike: Bike)

    @Delete
    suspend fun deleteBike(bike: Bike)

}