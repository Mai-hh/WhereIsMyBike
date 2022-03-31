package com.example.whereismybike.data

import com.example.whereismybike.model.Bike

object DataStore {

    private var dataSet = mutableListOf<Bike>()

    fun loadAddress(): List<Bike> {
        return mutableListOf()
    }

    fun addAddress() {
        dataSet.add(Bike(0, "TEST"))
    }

    fun getAddresses(): List<Bike> {
        return dataSet
    }
}