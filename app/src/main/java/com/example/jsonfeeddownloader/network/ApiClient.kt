package com.example.jsonfeeddownloader.network

import android.util.Log
import com.facebook.stetho.Stetho
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

object ApiClient
{

        private const val baseURL = "https://api.github.com"

        lateinit var apiClient: ApiInterface

        fun initialise()
        {
               val gson = GsonBuilder()
                       .setLenient()
                       .create()    //set lenient stops gson from only accepting json


                try {
                    val client = OkHttpClient.Builder().build()
                    val retrofit = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()

                    apiClient = retrofit.create(ApiInterface::class.java)
                }
            catch (e:Exception)
            {
                Log.e("In App Client", "Cant get client " + e.stackTrace)
            }




        }

}