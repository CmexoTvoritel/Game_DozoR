package com.example.gamedozor.presentation.ui.fragments.mygames.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.repository.GamesRepository
import com.example.gamedozor.presentation.ui.MateModel
import com.example.gamedozor.presentation.ui.fragments.mygames.model.MyGamesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyGamesViewModel @Inject constructor(
    private val repository: GamesRepository
): ViewModel() {

    private var _gameList = MutableStateFlow(emptyList<MyGamesModel>())
    val gameList = _gameList.asStateFlow()

    private val _matesList = MutableStateFlow(emptyList<MateModel>())
    val matesList = _matesList.asStateFlow()

    suspend fun getGameList() = withContext(Dispatchers.IO) {
        _gameList.value = repository.getGames()
    }

    fun getTeammatesList() {
        _matesList.value = repository.getMates()
    }
}