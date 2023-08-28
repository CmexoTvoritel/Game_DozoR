package com.example.gamedozor.data.api.LoginApi.service

import com.example.gamedozor.data.api.LoginApi.model.LoginModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("/auth/jwt/login")
    suspend fun loginUser(@Field("grant_type") grantType: String,
                          @Field("username") userLogin: String,
                          @Field("password") userPassword: String,
                          @Field("scope") scope: String,
                          @Field("client_id") clientId: String,
                          @Field("client_secret") clientSecret: String): Response<LoginModel>
}