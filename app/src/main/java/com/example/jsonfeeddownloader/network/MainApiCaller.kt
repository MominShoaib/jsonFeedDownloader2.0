package com.example.jsonfeeddownloader.network

import com.example.jsonfeeddownloader.model.GitHubUserModel
import com.example.jsonfeeddownloader.listeners.ApiCallBackListener
import retrofit2.Call
import retrofit2.Response

object MainApiCaller
{
        fun initialise()
        {
            ApiClient.initialise()
        }

    fun getUsers(listener: ApiCallBackListener) {
        val call: Call<List<GitHubUserModel>> = ApiClient.apiClient.getUsers()               // code change from page to user model  page in sample code had array of users


        call.enqueue(ApiHandler(USER_API_REQUEST_CODE, listener))
    }

    private const val USER_API_REQUEST_CODE = 1
}