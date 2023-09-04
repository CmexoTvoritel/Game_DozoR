package com.example.gamedozor.presentation.ui.fragments.FProfile.model

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
    val errorMessage: String,
)
