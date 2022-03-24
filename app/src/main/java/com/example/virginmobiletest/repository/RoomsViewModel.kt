package com.example.virginmobiletest.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmobiletest.dataresponse.People
import com.example.virginmobiletest.dataresponse.Rooms
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomsViewModel constructor(private val repository: ApiRepository)  : ViewModel() {
    val roomsList = MutableLiveData<List<Rooms>>()
    val errorMessage = MutableLiveData<String>()

    fun getRoomsInfo() {
        val response = repository.getAllRoomsData()
        response.enqueue(object : Callback<List<Rooms>> {

           override fun onResponse(call: Call<List<Rooms>>, response: Response<List<Rooms>>) {
               roomsList.postValue(response.body())

            }
            override fun onFailure(call: Call<List<Rooms>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}