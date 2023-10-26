package com.example.gamedozor.data.repository

import com.example.gamedozor.di.games.MyGamesApiInformation
import com.example.gamedozor.presentation.ui.MateModel
import com.example.gamedozor.presentation.ui.fragments.availablegames.model.AvailableGamesModel
import com.example.gamedozor.presentation.ui.fragments.chats.model.ChatsModel
import com.example.gamedozor.presentation.ui.fragments.mygames.model.MyGamesModel
import com.example.gamedozor.utils.PreferencesManager
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityRetainedScoped
class GamesRepository @Inject constructor(
    private val preferencesManager: PreferencesManager,
    private val myGamesApi: MyGamesApiInformation,
) {

    suspend fun getGames(): List<MyGamesModel> = getGamesValue()

    fun getMates() = getMatesValue()

    fun getChats() = getChatsValue()

    fun getAllGames() = getAllGamesValue()

    private suspend fun getGamesValue(): List<MyGamesModel> = withContext(Dispatchers.IO) {
        val listGamesUser = myGamesApi.getMyGames(userID = preferencesManager.userID)
        if(listGamesUser.body() != null) {
            val answerList = listGamesUser.body()!!.map { apiAnswer ->
                MyGamesModel(
                    nameGame = apiAnswer.name,
                    dataGame = apiAnswer.datetimeStart
                )
            }
//        val answer = listOf(
//            MyGamesModel("Crazy cat", 2, 7, "01:01:2002", "18:00"),
//            MyGamesModel("Big rabbit", 3, 10, "10:02:2003", "19:00")
//        )
//        return@withContext answer
            return@withContext answerList
        }
        return@withContext emptyList<MyGamesModel>()
    }

    private fun getMatesValue() = listOf(
        MateModel(nickname = "CmexoTvoritel", avatar = null),
        MateModel(nickname = "leyott", avatar = null),
        MateModel(nickname = "ex0d2s", avatar = null),
        MateModel(nickname = "th3caucasian", avatar = null)
    ) //TODO: Change with API

    private fun getChatsValue() = listOf(
        ChatsModel(nameGame = "Crazy cat", currentTeams = 2, maximumTeams = 7, dataGame = "01:01:2002", timeGame = "18:00"),
        ChatsModel(nameGame = "Big rabbit", currentTeams = 3, maximumTeams = 10, dataGame = "10:02:2003", timeGame = "19:00")
    ) //TODO: Change with API

    private fun getAllGamesValue() = listOf(
        AvailableGamesModel(nameGame = "Pig in pit", description = "In this game u need to win", currentTeams = 6, maximumTeams = 8, dataGame = "02:04:2004", timeGame = "20:20"),
        AvailableGamesModel(nameGame = "Blood shark", description = "In this game u must lose", currentTeams = 2, maximumTeams = 6, dataGame = "09:03:2004", timeGame = "19:30")
    ) //TODO: Change with API
}