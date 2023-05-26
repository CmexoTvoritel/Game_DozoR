package com.example.gamedozor.presentation.models

data class AvailableGamesModel(
    val nameGame: String,
    val currentTeams: Int,
    val maximumTeams: Int,
    val dataGame: String,
    val timeGame: String,
)
