package com.example.gamedozor.presentation.ui.fragments.FRegistration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.api.RegApi.model.RegAnswer
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.di.Registration.RegistrationApiInformation
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val regApi: RegistrationApiInformation): ViewModel() {

    init {
        //TODO:
    }

    suspend fun regUserInApp(user: RegistrationModel): RegAnswer = withContext(Dispatchers.Default) {
        val answerUser : RegModel
        if(user.password == user.confrimPassword) {
            answerUser = RegModel(
                email = user.email,
                is_active = true,
                is_superuser = user.is_superuser,
                is_verified = true,
                name = user.name,
                surname = user.surname,
                phone_number = user.phone_number,
                password = user.password,
                patronymic = "AYE",
            )
            val answer = regApi.regUser(answerUser)
            if(answer.body() != null) {
                return@withContext RegAnswer(isValide = true, message = "All is okay")
            }
            return@withContext RegAnswer(isValide = false, message = answer.message().lowercase())
        }
        return@withContext RegAnswer(isValide = false, message = "Passwords don't match")
    }

}