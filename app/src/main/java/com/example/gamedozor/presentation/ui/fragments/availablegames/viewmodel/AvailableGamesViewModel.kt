package com.example.gamedozor.presentation.ui.fragments.availablegames.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.repository.GamesRepository
import com.example.gamedozor.presentation.ui.fragments.availablegames.model.AvailableGamesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AvailableGamesViewModel @Inject constructor(
    private val repository: GamesRepository
) : ViewModel() {

    private var _games = MutableStateFlow<List<AvailableGamesModel>>(emptyList())
    val games = _games.asStateFlow()

    fun getGamesList() {
        _games.value = repository.getAllGames()
    }
}