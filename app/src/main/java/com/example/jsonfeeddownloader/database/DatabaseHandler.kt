package com.example.jsonfeeddownloader.database

import GitHubUserModel
import android.content.Context
import androidx.room.Room
import com.example.jsonfeeddownloader.activities.DatabaseOperations
import com.example.jsonfeeddownloader.listeners.DataBaseListener

object DatabaseHandler
{

private lateinit var database: AppDatabase


    fun initialise(context: Context)
    {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "todo-app-sample")
            .build()
    }

    fun saveUsersData(users: ArrayList<GitHubUserModel>, listener: DataBaseListener) {
//        DatabaseOperationsTask(
//            { saveUsers(users) },
//            DatabaseOperations.WRITE,
//            listener
//        ).execute()
    }

    fun getUsersData(listener: DataBaseListener) {
        DatabaseOperationsTask(
            { getUsers() },
            DatabaseOperations.READ,
            listener
        ).execute()
    }

    private fun saveUsers(users: ArrayList<GitHubUserModel>) {
        database.userDao().deleteAll()
        database.userDao().insertAll(users)
    }

    private fun getUsers(): ArrayList<GitHubUserModel> {
        return ArrayList(database.userDao().getAll())
    }
}