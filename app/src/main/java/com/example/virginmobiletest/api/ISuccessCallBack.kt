package com.example.virginmobiletest.api



 interface ISuccessCallBack<T> {

    fun onResponseSuccess(mResponse: T?)

     fun onResponseFailure(failureCode: String?)
}