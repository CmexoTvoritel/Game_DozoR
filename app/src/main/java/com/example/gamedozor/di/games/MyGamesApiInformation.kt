package com.example.gamedozor.di.games

import com.example.gamedozor.data.api.games.model.GameModel
import com.example.gamedozor.data.api.games.service.GamesService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyGamesApiInformation @Inject constructor(private val api: GamesService) {

    suspend fun getMyGames(userID: Int): Response<List<GameModel>> =
        api.getUserGames(userID = userID)
}