package com.example.gamedozor.data.repository

import com.example.gamedozor.data.api.registration.model.RegAnswer
import com.example.gamedozor.data.api.registration.model.RegModel
import com.example.gamedozor.data.db.model.UserEntity
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.di.login.LoginApiInformation
import com.example.gamedozor.di.profile.ProfileInformation
import com.example.gamedozor.di.registration.RegistrationApiInformation
import com.example.gamedozor.presentation.ui.fragments.login.model.LoginAnswer
import com.example.gamedozor.presentation.ui.fragments.profile.model.ErrorType
import com.example.gamedozor.presentation.ui.fragments.profile.model.ProfileModel
import com.example.gamedozor.presentation.ui.fragments.registration.model.RegistrationModel
import com.example.gamedozor.utils.PreferencesManager
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityRetainedScoped
class RegLoginRepository @Inject constructor(
    private val preferencesManager: PreferencesManager,
    private val regApi: RegistrationApiInformation,
    private val loginApi: LoginApiInformation,
    private val profileApi: ProfileInformation,
    private val userDao: UserDao
) {

    suspend fun regUser(user: RegistrationModel) : RegAnswer = withContext(Dispatchers.IO) {
        val answerUser : RegModel
        if(user.password == user.confirmPassword) {
            answerUser = RegModel(
                email = user.email,
                is_active = true,
                is_superuser = user.isSuperUser,
                is_verified = true,
                name = user.name,
                surname = user.surname,
                phone_number = user.phoneNumber,
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
                                alwaysLogin = true
                            )
                        )
                        preferencesManager.authKey = tryToLogin.body()!!.accessToken
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
        userPassword: String,
        alwaysLogin: Boolean = false
    ) : LoginAnswer = withContext(Dispatchers.IO) {
        try {
            val answer = loginApi.loginUser(userLogin = userLogin, password = userPassword)
            if (answer.body() != null) {
                preferencesManager.isAlwaysLogin = alwaysLogin
                preferencesManager.authKey = answer.body()!!.accessToken
                return@withContext LoginAnswer(isValid = true, message = "All is okay")
            }
            return@withContext LoginAnswer(isValid = false, message = "Something Went wrong")
        } catch (e: Exception) {
            return@withContext LoginAnswer(isValid = false, message = e.message.toString())
        }
    }

    suspend fun getUserData(): ProfileModel = withContext(Dispatchers.IO) {
        return@withContext getUserDataState()
    }

    private suspend fun getUserDataState(): ProfileModel = withContext(Dispatchers.IO) {
        val apiAnswer = profileApi.getUserInfo(authToken = preferencesManager.authKey!!)
        if(apiAnswer.body() != null) {
            val answer = ProfileModel(
                name = apiAnswer.body()!!.name,
                surname = apiAnswer.body()!!.surname,
                numOfGames = apiAnswer.body()!!.games_played,
                winGames = apiAnswer.body()!!.win_games,
                nickname = apiAnswer.body()!!.email,
                errorMessage = ErrorType.SUCCESS
            )
            preferencesManager.userID = apiAnswer.body()!!.id
            return@withContext answer
        }
        return@withContext ProfileModel(errorMessage = ErrorType.ERROR)
    }

}