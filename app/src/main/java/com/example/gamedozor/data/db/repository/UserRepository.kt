package com.example.gamedozor.data.db.repository

import com.example.gamedozor.data.db.model.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    fun getAllUsers(): List<UserEntity> = userDao.getAllUsers()

    fun insertUser(user: UserEntity) {
        userDao.insertUser(user = user)
    }

    fun updateUser(user: UserEntity) {
        userDao.updateUser(user = user)
    }

    fun deleteUser(userLogin: String) {
        userDao.deleteUser(userLogin = userLogin)
    }
}