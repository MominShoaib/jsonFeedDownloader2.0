package com.example.jsonfeeddownloader.listeners

interface ApiCallBackListener {
    fun onSuccess(requestCode: Int?, responseCode: Int?, data: Any?)
    fun onFailure(requestCode: Int?, message: String?)
}