package com.example.virginmobiletest.api

import com.example.virginmobiletest.dataresponse.People
import com.example.virginmobiletest.dataresponse.Rooms
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("people")
    fun getPeopleData(): Call<List<People>>

    @GET("rooms")
    fun getRoomsData(): Call<List<Rooms>>
}