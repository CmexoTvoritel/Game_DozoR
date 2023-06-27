package com.example.gamedozor.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gamedozor.presentation.models.AvailableGamesModel
import com.example.gamedozor.presentation.models.MyGamesModel

class MyGamesViewModel: ViewModel() {

    fun addItemsToRV() = listOf(
        MyGamesModel("Crazy cat", 2, 7, "01:01:2002", "18:00"),
        MyGamesModel("Big rabbit", 3, 10, "10:02:2003", "19:00")
    )
}