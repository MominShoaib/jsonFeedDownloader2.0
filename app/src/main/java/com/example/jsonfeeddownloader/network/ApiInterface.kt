package com.example.jsonfeeddownloader.network

import GitHubUserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface
{
    @GET("/users")
    fun getUsers(@Query("delay") delay: Int) : Call<GitHubUserModel>

}