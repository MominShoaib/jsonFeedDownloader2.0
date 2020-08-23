package com.example.jsonfeeddownloader.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonfeeddownloader.R
import com.example.jsonfeeddownloader.adapter.CustomAdapter
import com.example.jsonfeeddownloader.model.GitHubUserModel
import com.example.jsonfeeddownloader.utitlities.showToast
import com.example.jsonfeeddownloader.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private var fetchingForFirstTime = true
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initViewModel()
        getUserDataForFirstTime()
        observeUsersList()
        setListeners()


    }

    private fun setDataToRecyclerView(githubUser: ArrayList<GitHubUserModel>) {

        val customAdapter = CustomAdapter(githubUser, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //is this needed or not ?
        customAdapter.notifyDataSetChanged()
        recyclerView.adapter = customAdapter


    }

    private fun setListeners() {

        swipeRefresh.setOnRefreshListener()
        {
            showToast("Getting users again after swipe to refresh")
            viewModel.getUsers(fetchingForFirstTime)
            swipeRefresh.isRefreshing = false
        }


    }


    private fun initViewModel() {


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


    }

    private fun observeUsersList() {


        viewModel.userLiveData.observe(this, Observer {
            setDataToRecyclerView(it)

        })


    }

    private fun getUserDataForFirstTime() {
        viewModel.getUsers(fetchingForFirstTime)
        fetchingForFirstTime = false
    }


}