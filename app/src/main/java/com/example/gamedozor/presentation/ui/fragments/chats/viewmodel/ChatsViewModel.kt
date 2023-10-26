package com.example.gamedozor.presentation.ui.fragments.chats.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gamedozor.data.repository.GamesRepository
import com.example.gamedozor.presentation.ui.fragments.chats.model.ChatsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val repository: GamesRepository
): ViewModel() {

    private var _listChats = MutableStateFlow(emptyList<ChatsModel>())
    val listChats = _listChats.asStateFlow()


    fun getChatsList() {
        _listChats.value = repository.getChats()
    }
}