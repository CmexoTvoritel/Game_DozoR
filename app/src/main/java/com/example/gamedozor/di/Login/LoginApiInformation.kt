package com.example.gamedozor.di.Login

import com.example.gamedozor.data.api.LoginApi.model.LoginModel
import com.example.gamedozor.data.api.LoginApi.service.LoginService
import com.example.gamedozor.di.scopes.FragmentScope
import retrofit2.Response
import javax.inject.Inject

@FragmentScope
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