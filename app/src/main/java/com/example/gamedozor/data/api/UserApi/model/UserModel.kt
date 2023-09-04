package com.example.gamedozor.data.api.UserApi.model

data class UserModel(
    val email: String,
    val games_played: Int,
    val id: Int,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean,
    val name: String,
    val patronymic: String,
    val phone_number: String,
    val surname: String,
    val win_games: Int
)