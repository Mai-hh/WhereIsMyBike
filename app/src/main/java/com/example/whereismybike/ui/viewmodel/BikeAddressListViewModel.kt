package com.example.whereismybike.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whereismybike.data.DataStore
import com.example.whereismybike.model.BikeAddress
import com.example.whereismybike.ui.BikeAddressListFragment

private const val TAG = "BikeAddressViewModel"
class BikeAddressListViewModel : ViewModel() {

    private var _bikeAddresses = MutableLiveData<List<BikeAddress>>()
    val bikeAddresses: LiveData<List<BikeAddress>> = _bikeAddresses

    init {
        _bikeAddresses.value = DataStore.loadAddress()
    }

    fun addBikeAddress() {
        DataStore.addAddress()
        Log.d(TAG, "add" + bikeAddresses.value?.size)
        _bikeAddresses.value = DataStore.getAddresses()
    }

}