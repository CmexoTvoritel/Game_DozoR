package com.example.gamedozor.data.db.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gamedozor.data.db.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_info_table")
    fun getAllUsers(): List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Query("DELETE FROM user_info_table WHERE userLogin = :userLogin")
    fun deleteUser(userLogin: String)
}