package com.example.jsonfeeddownloader.network

import GitHubUserModel
import com.example.jsonfeeddownloader.listeners.ApiCallBackListener
import retrofit2.Call

object MainApiCaller
{
        fun initialise()
        {
            ApiClient.initialise()
        }

    fun getUsers(listener: ApiCallBackListener) {
        val call: Call<GitHubUserModel> = ApiClient.apiClient.getUsers(1)               // code change from page to user model  page in sample code had array of users
        call.enqueue(ApiHandler(USER_API_REQUEST_CODE, listener))
    }

    private const val USER_API_REQUEST_CODE = 1
}