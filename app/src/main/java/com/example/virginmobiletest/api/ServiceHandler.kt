package com.example.virginmobiletest.api

import android.content.Context
import com.example.virginmobiletest.api.ISuccessCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceHandler<T>() {
    fun request(
        mContext: Context?,
        call: Call<T>,
        mSuccessHandler: ISuccessCallBack<T>
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    mSuccessHandler.onResponseSuccess(response.body())
                } else {

                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                mSuccessHandler.onResponseFailure(t.toString())
            }
        })
    }
}