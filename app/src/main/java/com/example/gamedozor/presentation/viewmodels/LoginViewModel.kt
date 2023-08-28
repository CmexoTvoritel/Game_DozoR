package com.example.gamedozor.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.api.LoginApi.model.LoginModel
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.presentation.ui.fragments.LoginAnswer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel(): ViewModel() {

    suspend fun loginUserInApp(loginApi: LoginApiInformation, userLogin: String, userPassword: String): LoginAnswer = withContext(Dispatchers.Default) {
        val answer = loginApi.loginUser(userLogin = userLogin, password = userPassword)
        if(answer.body() != null) {
            return@withContext LoginAnswer(isValide = true, message = "All is okay")
        }
        return@withContext LoginAnswer(isValide = false, message = "Something Went wrong") //TODO: Improve message
    }
}