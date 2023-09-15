package com.example.gamedozor.presentation.ui.fragments.FProfile.viewmodel


import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.di.Profile.ProfileInformation
import com.example.gamedozor.presentation.ui.fragments.FProfile.model.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val api: ProfileInformation,
    private val userDao: UserDao) : ViewModel() {

    suspend fun getAuthToken() : String = withContext(Dispatchers.Default) {
        val listOfUsers = userDao.getAllUsers()
        return@withContext "Bearer ${listOfUsers[0].authToken}"
    }

    suspend fun getDataAboutUser(authToken: String) : ProfileModel = withContext(Dispatchers.Main) {
        var answer : ProfileModel
        val userInformation = api.getUserInfo(authToken = authToken)
        if(userInformation.body() != null) {
            answer = ProfileModel(
                errorMessage = "All is okay",
                name = userInformation.body()!!.name,
                surname = userInformation.body()!!.surname,
                numOfGames = userInformation.body()!!.games_played,
                winGames = userInformation.body()!!.win_games,
            )
            return@withContext answer
        }
        answer = ProfileModel(errorMessage = "Something went wrong")
        return@withContext answer
    }
}