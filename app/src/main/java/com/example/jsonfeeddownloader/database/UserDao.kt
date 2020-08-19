package com.example.jsonfeeddownloader.database

import GitHubUserModel
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<GitHubUserModel>

    @Insert
    fun insert(vararg user: GitHubUserModel)

    @Insert
    fun insertAll(users: List<GitHubUserModel>)

    @Delete
    fun delete(user: GitHubUserModel)

    @Query("DELETE from users")
    fun deleteAll()
}