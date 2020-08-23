package com.example.jsonfeeddownloader.mainrepository

import com.example.jsonfeeddownloader.model.GitHubUserModel
import android.content.Context
import com.example.jsonfeeddownloader.database.DatabaseHandler
import com.example.jsonfeeddownloader.listeners.ApiCallBackListener
import com.example.jsonfeeddownloader.listeners.AppCommonDataListener
import com.example.jsonfeeddownloader.listeners.DataBaseListener
import com.example.jsonfeeddownloader.network.MainApiCaller


// repo should have instances of cache, network and db classes
// repo should be a singleton/object so only one instance of repo is used throughout the application
class MainRepository private constructor(
 private val context: Context,
private val listener: AppCommonDataListener
) : ApiCallBackListener, DataBaseListener
{


    init {
        MainApiCaller.initialise()
        DatabaseHandler.initialise(context)
    }


// get users is public so that it can be called from view model
    fun getUsers(fetchForFirstTime: Boolean)
    {
            if(fetchForFirstTime)
            {
                getDataFromNetwork()
            }
            else
            {
                getDataFromDB()
            }
    }

    private fun getDataFromDB()
    {
        DatabaseHandler.getUsersData(this)
    }


    private fun getDataFromNetwork()
    {
        MainApiCaller.getUsers(this)
    }

    private fun saveDataToDatabase(users: ArrayList<GitHubUserModel>)
    {
        DatabaseHandler.saveUsersData(users, this)
    }
    override fun onSuccess(requestCode: Int?, responseCode: Int?, data: Any?) {
         val user = data as ArrayList<GitHubUserModel>
        saveDataToDatabase(user)
        listener.onDataReceived(user)

        // look into data handling as array list required but object present
    }

    override fun onFailure(requestCode: Int?, message: String?) {
        listener.onDataNotReceived()
    }


    override fun onOperationSuccess(data: Any?) {
        listener.onDataReceived(data)
    }

    override fun onOperationFailed() {
        listener.onDataNotReceived()
    }

    //creating singleton object
    companion object {
        private lateinit var INSTANCE: MainRepository


        fun getInstance(context: Context, listener: AppCommonDataListener): MainRepository {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = MainRepository(context, listener)

            }

            return INSTANCE
        }

    }




}