package com.example.whereismybike.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whereismybike.data.DataStore
import com.example.whereismybike.model.Bike

private const val TAG = "BikeAddressViewModel"
class BikeAddressListViewModel : ViewModel() {

    private var _bikes = MutableLiveData<List<Bike>>()
    val bikes: LiveData<List<Bike>> = _bikes

    init {
        _bikes.value = DataStore.loadAddress()
    }

    fun addBikeAddress() {
        DataStore.addAddress()
        Log.d(TAG, "add" + bikes.value?.size)
        _bikes.value = DataStore.getAddresses()
    }

}