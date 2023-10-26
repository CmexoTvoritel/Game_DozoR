package com.example.gamedozor.presentation.ui.fragments.profile.viewmodel


import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.data.repository.RegLoginRepository
import com.example.gamedozor.di.profile.ProfileInformation
import com.example.gamedozor.presentation.ui.fragments.profile.model.ErrorType
import com.example.gamedozor.presentation.ui.fragments.profile.model.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: RegLoginRepository
) : ViewModel() {

    suspend fun getDataAboutUser() : ProfileModel = withContext(Dispatchers.Main) {
        var answer : ProfileModel
        val userInformation = repository.getUserData()
        if(userInformation.errorMessage != ErrorType.ERROR) {
            answer = ProfileModel(
                errorMessage = ErrorType.SUCCESS,
                name = userInformation.name,
                surname = userInformation.surname,
                numOfGames = userInformation.numOfGames,
                winGames = userInformation.winGames,
            )
            return@withContext answer
        }
        answer = ProfileModel(errorMessage = ErrorType.ERROR)
        return@withContext answer
    }
}