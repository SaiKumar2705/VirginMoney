package com.example.virginmobiletest.dataresponse

import com.google.gson.annotations.SerializedName

data class People(
@SerializedName("createdAt")
    var createdAt : String,
@SerializedName("firstName")
    var firstName : String,
@SerializedName("lastName")
    var lastName : String,
@SerializedName("avatar")
    var avatar : String,
@SerializedName("email")
    var email : String,
@SerializedName("jobtitle")
    var jobtitle : String,
@SerializedName("favouriteColor")
    var favouriteColor : String,
@SerializedName("id")
    var id : Int,

)
