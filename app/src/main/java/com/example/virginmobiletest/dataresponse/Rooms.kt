package com.example.virginmobiletest.dataresponse

import com.google.gson.annotations.SerializedName

data class Rooms(
    @SerializedName("createdAt")
    var createdAt : String,
    @SerializedName("isOccupied")
    var isOccupied : Boolean,
    @SerializedName("maxOccupancy")
    var maxOccupancy : String,
    @SerializedName("id")
    var id : Int,)
