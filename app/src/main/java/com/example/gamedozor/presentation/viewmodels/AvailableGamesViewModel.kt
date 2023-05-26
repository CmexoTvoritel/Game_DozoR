package com.example.gamedozor.presentation.viewmodels

import android.content.res.loader.ResourcesProvider
import androidx.lifecycle.ViewModel
import com.example.gamedozor.presentation.models.AvailableGamesModel

class AvailableGamesViewModel : ViewModel() {

    fun addGamesToRV() = listOf(
        AvailableGamesModel("Crazy cat", 0, 0, "01:01:2002", "18:00"),
        AvailableGamesModel("Fcking rabbit", 0, 0, "10:02:2003", "19:00"))
}