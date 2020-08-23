package com.example.jsonfeeddownloader.viewmodels


import com.example.jsonfeeddownloader.model.GitHubUserModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jsonfeeddownloader.listeners.AppCommonDataListener
import com.example.jsonfeeddownloader.mainrepository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application),
    AppCommonDataListener
{
    private var mainRepository : MainRepository = MainRepository.getInstance(application,this)  //getting repo instance


    // creating private mutable live data and then exposing live data to view to observe and act upon
    private val userMutableLiveData : MutableLiveData<ArrayList<GitHubUserModel>> = MutableLiveData()
    val userLiveData : LiveData<ArrayList<GitHubUserModel>> = userMutableLiveData

    // get users made public so view can access and call this
    fun getUsers(fetchingForFirstTime : Boolean)
    {
       mainRepository.getUsers(fetchingForFirstTime)
    }

    override fun onDataReceived(data: Any?) {
        userMutableLiveData.postValue(data as ArrayList<GitHubUserModel>)
    }

    override fun onDataNotReceived() {
        userMutableLiveData.postValue(null)
    }

}