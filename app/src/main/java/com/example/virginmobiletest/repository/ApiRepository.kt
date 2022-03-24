package com.example.virginmobiletest.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.virginmobiletest.BaseApplication
import com.example.virginmobiletest.api.ApiInterface
import com.example.virginmobiletest.api.ISuccessCallBack
import com.example.virginmobiletest.dataresponse.People
import retrofit2.Call

class ApiRepository(private val apiInterface: ApiInterface)  {
    fun getAllPeopleData() = apiInterface.getPeopleData()
    fun getAllRoomsData()= apiInterface.getRoomsData()
}