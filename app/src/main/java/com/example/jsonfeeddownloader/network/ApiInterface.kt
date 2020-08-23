package com.example.jsonfeeddownloader.network

import com.example.jsonfeeddownloader.model.GitHubUserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface
{
//    @GET("/users")
//    fun getUsers(@Query("delay") delay: Int) : Call<GitHubUserModel>

//    @GET("/users")
//    fun getUsers(@Query("users") user: Int): Call<GitHubUserModel>

    @GET("/users")
    fun getUsers() : Call<List<GitHubUserModel>>


}