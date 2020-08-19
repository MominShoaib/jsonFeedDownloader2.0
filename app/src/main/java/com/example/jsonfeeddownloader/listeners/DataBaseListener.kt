package com.example.jsonfeeddownloader.listeners

interface DataBaseListener {

    fun onOperationSuccess(data: Any?)
    fun onOperationFailed()
}