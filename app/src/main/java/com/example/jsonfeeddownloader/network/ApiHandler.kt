package com.example.jsonfeeddownloader.network

import android.widget.Toast
import com.example.jsonfeeddownloader.listeners.ApiCallBackListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiHandler<T>(private val requestCode: Int?, private val listener: ApiCallBackListener?) :
    Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {



            listener?.onSuccess(requestCode, response.code(), response.body())

    }

    override fun onFailure(call: Call<T>, throwable: Throwable) {
        listener?.onFailure(requestCode, throwable.localizedMessage)
    }
}