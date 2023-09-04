package com.example.gamedozor.presentation.ui.fragments.FMyGames.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.presentation.ui.fragments.FMyGames.model.MyGamesModel

class MyGamesViewModel: ViewModel() {

    fun addItemsToRV() = listOf(
        MyGamesModel("Crazy cat", 2, 7, "01:01:2002", "18:00"),
        MyGamesModel("Big rabbit", 3, 10, "10:02:2003", "19:00")
    )
}