package com.example.gamedozor.presentation.ui.fragments.profile.model

data class ProfileModel(
    val name: String = "-",
    val surname: String = "-",
    val nickname: String = "-",
    val age: Int = 0,
    val city: String = "-",
    val hobbies: String = "-",
    val aboutUser: String = "-",
    val numOfGames: Int = 0,
    val winGames: Int = 0,
    val errorMessage: ErrorType,
)

enum class ErrorType {
    SUCCESS,
    ERROR
}
