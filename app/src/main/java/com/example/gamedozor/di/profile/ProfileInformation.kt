package com.example.gamedozor.di.profile

import com.example.gamedozor.data.api.user.model.UserModel
import com.example.gamedozor.data.api.user.service.UserService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileInformation @Inject constructor(private val api: UserService) {

    suspend fun getUserInfo(authToken: String): Response<UserModel> = api.getUserInfo(authToken = authToken)
}