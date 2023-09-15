package com.example.gamedozor.presentation.ui.fragments.FRegistration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.data.repository.RegistrationRepository
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.di.Registration.RegistrationApiInformation
import com.example.gamedozor.presentation.ui.UIState
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val regApi: RegistrationApiInformation,
    private val loginApi: LoginApiInformation,
    private val userDao: UserDao
): ViewModel() {

    private var _response = MutableStateFlow(UIState.LOADING)
    val response: StateFlow<UIState>
        get() = _response

    suspend fun regUserInApp(user: RegistrationModel) = withContext(Dispatchers.IO) {
        val repository = RegistrationRepository()
        val answer = repository.regUser(
            user = user,
            regApi = regApi,
            loginApi = loginApi,
            userDao = userDao)

        _response.value = if(answer.isValide)
            UIState.SUCCESS
        else
            UIState.FAILED
    }

}