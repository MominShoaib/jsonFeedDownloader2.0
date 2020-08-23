package com.example.jsonfeeddownloader.database

import com.example.jsonfeeddownloader.model.GitHubUserModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GitHubUserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun userDao() : UserDao
}


//To access your app's data using the Room persistence library, you work with data access objects, or DAOs.
// This set of Dao objects forms the main component of Room,
// as each DAO includes methods that offer abstract access to your app's database.
//By accessing a database using a DAO class instead of query builders or direct queries,
// you can separate different components of your database architecture