package com.example.virginmobiletest

import android.app.Application
import com.example.virginmobiletest.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL : String = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"
class BaseApplication : Application() {

    companion object {
        lateinit var retrofit: Retrofit
        fun getApiInterface(): ApiInterface {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}