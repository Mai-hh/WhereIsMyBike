package com.example.whereismybike.data

import com.example.whereismybike.TestFile
import com.example.whereismybike.model.BikeAddress

object DataStore {

    private var dataSet = mutableListOf<BikeAddress>()

    fun loadAddress(): List<BikeAddress> {
        return mutableListOf()
    }

    fun addAddress() {
        dataSet.add(BikeAddress(0))
    }

    fun getAddresses(): List<BikeAddress> {
        return dataSet
    }
}