package com.example.whereismybike.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.whereismybike.data.BikeDao
import com.example.whereismybike.model.Bike
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val TAG = "BikeAddressViewModel"
class BikeListViewModel (
    private val bikeDao: BikeDao
) : ViewModel() {

    // Flow to LiveData
    val bikes: LiveData<List<Bike>> = bikeDao.getAllBikes().asLiveData()

    fun getBike(id: Int): LiveData<Bike> {
        return bikeDao.getBikeById(id).asLiveData()
    }

    fun addBikeAddress() {
        val formatter = DateTimeFormatter.ofPattern("yyyy.LL.dd eee hh:mm a")
        val now: String = LocalDateTime.now().format(formatter)
        val bike = Bike(dateTime = now)
        Log.d(TAG, "$bike")
        // 非主线程协程 IO 区
        viewModelScope.launch(Dispatchers.IO) {
            bikeDao.insertBike(bike)
        }
    }

}

class BikeListViewModelFactory(private val bikeDao: BikeDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BikeListViewModel::class.java)) {
            return BikeListViewModel(bikeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}