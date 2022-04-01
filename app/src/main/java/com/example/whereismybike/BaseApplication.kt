package com.example.whereismybike

import android.app.Application
import com.example.whereismybike.data.BikeDatabase

class BaseApplication : Application() {

    val database: BikeDatabase by lazy {
        BikeDatabase.getDatabase(this)
    }
}