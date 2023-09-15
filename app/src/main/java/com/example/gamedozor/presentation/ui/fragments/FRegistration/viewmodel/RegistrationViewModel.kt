package com.example.gamedozor.presentation.ui.fragments.FRegistration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.repository.RegLoginRepository
import com.example.gamedozor.presentation.ui.UIState
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: RegLoginRepository
): ViewModel() {

    private var _response = MutableStateFlow(UIState.LOADING)
    val response = _response.asStateFlow()

    suspend fun regUserInApp(user: RegistrationModel) = withContext(Dispatchers.IO) {
        val answer = repository.regUser(user = user)

        _response.value = if(answer.isValide)
            UIState.SUCCESS
        else
            UIState.FAILED
    }

}