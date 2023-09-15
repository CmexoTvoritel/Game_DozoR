package com.example.gamedozor.data.repository

import com.example.gamedozor.data.api.RegApi.model.RegAnswer
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.data.db.model.UserEntity
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.di.Registration.RegistrationApiInformation
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegistrationRepository {

    suspend fun regUser(
        user: RegistrationModel,
        regApi: RegistrationApiInformation,
        loginApi: LoginApiInformation,
        userDao: UserDao) : RegAnswer = withContext(Dispatchers.IO) {
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
                patronymic = "someName",
            )
            val answer = regApi.regUser(answerUser)
            if(answer.body() != null) {
                val tryToLogin = loginApi.loginUser(user.email, user.password)
                if(tryToLogin.body() != null) {
                    userDao.insertUser(
                        UserEntity(
                            userLogin = user.email,
                            userPassword = user.password,
                            alwaysLogin = true,
                            authToken = tryToLogin.body()!!.access_token
                        )
                    )
                    return@withContext RegAnswer(isValide = true, message = "All is okay")
                }
            }
            return@withContext RegAnswer(isValide = false, message = answer.message().lowercase())
        }
        return@withContext RegAnswer(isValide = false, message = "Passwords don't match")
    }

}