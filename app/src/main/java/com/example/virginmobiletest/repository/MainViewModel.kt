package com.example.virginmobiletest.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmobiletest.dataresponse.People
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: ApiRepository)  : ViewModel() {
    val peopleList = MutableLiveData<List<People>>()
    val errorMessage = MutableLiveData<String>()
    fun getPeopleInfo() {
        val response = repository.getAllPeopleData()
        response.enqueue(object : Callback<List<People>> {
           override fun onResponse(call: Call<List<People>>, response: Response<List<People>>) {
               peopleList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<People>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}