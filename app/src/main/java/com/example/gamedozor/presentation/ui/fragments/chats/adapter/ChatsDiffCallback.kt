package com.example.gamedozor.presentation.ui.fragments.chats.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.gamedozor.presentation.ui.fragments.chats.model.ChatsModel

class ChatsDiffCallback: DiffUtil.ItemCallback<ChatsModel>() {
    override fun areItemsTheSame(
        oldItem: ChatsModel,
        newItem: ChatsModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ChatsModel,
        newItem: ChatsModel
    ): Boolean {
        return oldItem.nameGame == newItem.nameGame
                && oldItem.dataGame == newItem.dataGame
                && oldItem.timeGame == newItem.dataGame
    }
}