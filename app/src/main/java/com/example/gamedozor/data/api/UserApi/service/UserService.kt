package com.example.gamedozor.data.api.UserApi.service

import com.example.gamedozor.data.api.UserApi.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {

    @GET("/users/me")
    suspend fun getUserInfo(@Header("Authorization") authToken: String): Response<UserModel>
}