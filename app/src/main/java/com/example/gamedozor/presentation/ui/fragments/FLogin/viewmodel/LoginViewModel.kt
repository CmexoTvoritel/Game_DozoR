package com.example.gamedozor.presentation.ui.fragments.FLogin.viewmodel

import androidx.compose.runtime.MutableFloatState
import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.db.model.UserEntity
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.data.repository.RegLoginRepository
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.presentation.ui.UIState
import com.example.gamedozor.presentation.ui.fragments.FLogin.model.LoginAnswer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RegLoginRepository
): ViewModel() {

    private var _response = MutableStateFlow(UIState.LOADING)
    val response = _response.asStateFlow()

    suspend fun loginUserInApp(
        userLogin: String,
        userPassword: String
    ) = withContext(Dispatchers.Default) {
        val answer = repository.loginUser(
            userLogin = userLogin,
            userPassword = userPassword)

        _response.value = if(answer.isValid)
            UIState.SUCCESS
        else
            UIState.FAILED
    }
}