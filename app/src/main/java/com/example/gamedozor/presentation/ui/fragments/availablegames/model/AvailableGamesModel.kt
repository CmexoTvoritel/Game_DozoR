package com.example.gamedozor.presentation.ui.fragments.availablegames.model

data class AvailableGamesModel(
    val nameGame: String,
    val description: String? = null,
    val currentTeams: Int,
    val maximumTeams: Int,
    val dataGame: String,
    val timeGame: String,
)
