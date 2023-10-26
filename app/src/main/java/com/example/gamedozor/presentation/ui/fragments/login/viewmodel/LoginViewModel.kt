package com.example.gamedozor.presentation.ui.fragments.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.repository.RegLoginRepository
import com.example.gamedozor.presentation.ui.fragments.registration.model.UIState
import com.example.gamedozor.utils.PreferencesManager
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
        userPassword: String,
        isAlwaysLogin: Boolean,
    ) = withContext(Dispatchers.Default) {
        val answer = repository.loginUser(
            userLogin = userLogin,
            userPassword = userPassword,
            alwaysLogin = isAlwaysLogin)
        _response.value = if(answer.isValid)
            UIState.SUCCESS
        else
            UIState.FAILED
    }
}