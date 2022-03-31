package com.example.whereismybike.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bike_db")
data class Bike (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val dateTime: String
)