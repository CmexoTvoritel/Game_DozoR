package com.example.gamedozor.di.login

import com.example.gamedozor.data.api.login.model.LoginModel
import com.example.gamedozor.data.api.login.service.LoginService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginApiInformation @Inject constructor(private val api: LoginService) {

    suspend fun loginUser(userLogin: String, password: String): Response<LoginModel> =
        api.loginUser(
            grantType = "",
            userLogin = userLogin,
            userPassword = password,
            clientId = "",
            clientSecret = "",
            scope = "")
}