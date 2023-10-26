package com.example.gamedozor.data.api.games.service

import com.example.gamedozor.data.api.games.model.GameModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface GamesService {

    @FormUrlEncoded
    @GET("/games")
    suspend fun getUserGames(@Field("user_id") userID: Int): Response<List<GameModel>>


}