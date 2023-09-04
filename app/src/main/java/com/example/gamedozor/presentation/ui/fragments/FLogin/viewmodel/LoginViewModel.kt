package com.example.gamedozor.presentation.ui.fragments.FLogin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.presentation.ui.fragments.FLogin.model.LoginAnswer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginApi: LoginApiInformation, private val userDao: UserDao): ViewModel() {

    init {
        //TODO:
    }

    suspend fun loginUserInApp(userLogin: String, userPassword: String): LoginAnswer = withContext(Dispatchers.Default) {
        val answer = loginApi.loginUser(userLogin = userLogin, password = userPassword)
        if(answer.body() != null) {
            return@withContext LoginAnswer(isValide = true, message = "All is okay")
        }
        return@withContext LoginAnswer(isValide = false, message = "Something Went wrong") //TODO: Improve message
    }
}