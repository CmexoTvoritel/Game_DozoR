package com.example.gamedozor.data.api.RegApi.service

import com.example.gamedozor.data.api.RegApi.model.RegModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegService {

    @POST("/auth/register")
    suspend fun registerUser(@Body requestBody: RegModel): Response<RegModel>
}