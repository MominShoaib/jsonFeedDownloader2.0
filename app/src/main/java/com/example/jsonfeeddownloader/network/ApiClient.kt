package com.example.jsonfeeddownloader.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient
{

        private const val baseURL = "https://api.github.com"

        lateinit var apiClient: ApiInterface

        fun initialise()
        {
               val gson = GsonBuilder()
                       .setLenient()
                       .create()    //set lenient stops gson from only accepting json


                val client = OkHttpClient.Builder().build()
                val retrofit = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()


                apiClient = retrofit.create(ApiInterface::class.java)
        }

}