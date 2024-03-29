package com.example.gamedozor.presentation.ui.fragments.FAvailableGames.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.model.AvailableGamesModel

class AvailableGamesViewModel : ViewModel() {

    fun addGamesToRV() = listOf(
        AvailableGamesModel("Crazy cat", 2, 7, "01:01:2002", "18:00"),
        AvailableGamesModel("Big rabbit", 3, 10, "10:02:2003", "19:00")
    )
}