package com.example.gamedozor.data.repository

import com.example.gamedozor.data.api.RegApi.model.RegAnswer
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.data.db.model.UserEntity
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.di.Registration.RegistrationApiInformation
import com.example.gamedozor.presentation.ui.fragments.FLogin.model.LoginAnswer
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityRetainedScoped
class RegLoginRepository @Inject constructor(
    private val regApi: RegistrationApiInformation,
    private val loginApi: LoginApiInformation,
    private val userDao: UserDao
) {

    suspend fun regUser(user: RegistrationModel) : RegAnswer = withContext(Dispatchers.IO) {
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
            try {
                val answer = regApi.regUser(answerUser)
                if (answer.body() != null) {
                    val tryToLogin = loginApi.loginUser(user.email, user.password)
                    if (tryToLogin.body() != null) {
                        userDao.insertUser(
                            UserEntity(
                                userLogin = user.email,
                                userPassword = user.password,
                                alwaysLogin = true,
                                authToken = tryToLogin.body()!!.accessToken
                            )
                        )
                        return@withContext RegAnswer(isValide = true, message = "All is okay")
                    }
                }
                return@withContext RegAnswer(
                    isValide = false,
                    message = answer.message().lowercase()
                )
            } catch (e: Exception) {
                return@withContext RegAnswer(isValide = false, message = e.message.toString())
            }
        }
        return@withContext RegAnswer(isValide = false, message = "Passwords don't match")
    }

    suspend fun loginUser(
        userLogin: String,
        userPassword: String
    ) : LoginAnswer = withContext(Dispatchers.IO) {
        try {
            val answer = loginApi.loginUser(userLogin = userLogin, password = userPassword)
            if (answer.body() != null) {
                userDao.updateUser(
                    UserEntity(
                        userLogin = userLogin,
                        userPassword = userPassword,
                        alwaysLogin = true,
                        authToken = answer.body()!!.accessToken
                    )
                ) //TODO:

                return@withContext LoginAnswer(isValid = true, message = "All is okay")
            }
            return@withContext LoginAnswer(isValid = false, message = "Something Went wrong")
        } catch (e: Exception) {
            return@withContext LoginAnswer(isValid = false, message = e.message.toString())
        }
    }
}